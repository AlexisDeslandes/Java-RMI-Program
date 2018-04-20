import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
    @author Alexis Deslandes
**/
public class Serveur {

    private static Serveur serveur = new Serveur();
    private Map<Integer,InterfaceClient> clients;
    private static int clientIdGenerator = 0;

    public static Serveur getINSTANCE(){
        return serveur;
    }

    private Serveur(){
        this.clients = new HashMap<>();
    }

    public void envoyerDonnees(String message){
        for (int i =0;i<clients.size();i++) {
            InterfaceClient client =(InterfaceClient) clients.values().toArray()[i];
            int clientId =(int) clients.keySet().toArray()[i];
            try {
                client.receptionne("Client numéro : "+ clientId+", "+ message + ", le nombre de personnes connectées est de : " + clients.size());
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("Problèmes rencontrés dans l'envoie du message : Suppression du client.");
                clients.remove(client);
            }
        }
    }

    public void recoieAbonnement(InterfaceClient interfaceClient) {
        int id = clientIdGenerator++;
        this.clients.put(id,interfaceClient);
        System.out.println("Un nouveau client s'est connecté ! Client numéro : "+id);
    }

    public void recoieDesabonnement(InterfaceClient interfaceClient) {
        this.clients.remove(interfaceClient);
        System.out.println("Un client a souhaité se déconnecté !");
    }
}
