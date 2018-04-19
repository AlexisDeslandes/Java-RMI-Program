import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
    @author Alexis Deslandes
**/
public class Serveur {

    private static Serveur serveur = new Serveur();
    private List<InterfaceClient> clients;

    public static Serveur getINSTANCE(){
        return serveur;
    }

    private Serveur(){
        this.clients = new LinkedList<>();
    }

    public void envoyerDonnees(String message){
        for (InterfaceClient client : clients) {
            try {
                client.receptionne(message + ", le nombre de personnes connectées est de : " + clients.size());
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("Problèmes rencontrés dans l'envoie du message : Suppression du client.");
                clients.remove(client);
            }
        }
    }

    public void recoieAbonnement(InterfaceClient interfaceClient) {
        this.clients.add(interfaceClient);
        System.out.println("Un nouveau client s'est connecté !");
    }

    public void recoieDesabonnement(InterfaceClient interfaceClient) {
        this.clients.remove(interfaceClient);
        System.out.println("Un client a souhaité se déconnecté !");
    }
}
