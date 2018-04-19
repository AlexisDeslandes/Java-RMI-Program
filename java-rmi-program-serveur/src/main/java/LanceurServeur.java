import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

/**
    @author Alexis Deslandes
**/
public class LanceurServeur {

    public static void main(String[] args) throws RemoteException, UnknownHostException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        ServeurDistantInterface objetPartage = new ServeurDistant();
        String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ServeurDistantInterface";
        Naming.rebind(url, objetPartage);
        System.out.println("Le service est maintenant ouvert et l'objet est partage");
        envoyeDonneesEnBoucle();
    }

    private static void envoyeDonneesEnBoucle(){
        Serveur serveur = Serveur.getINSTANCE();
        Scanner scanner = new Scanner(System.in);
        String donnee = null;
        do{
            System.out.println("Veuillez rentrer le message que vous souhaitez faire parvenir aux clients !");
            System.out.println("Si vous voulez stopper le client, rentrez q dans l'entrée standart !\n\n\n");
            donnee = scanner.nextLine();
            if (donnee.equals("q")) break;
            serveur.envoyerDonnees(donnee);
        }while (true);
    }

}
