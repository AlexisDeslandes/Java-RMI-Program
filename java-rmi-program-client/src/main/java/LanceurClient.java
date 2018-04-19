import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.util.Scanner;

/**
    @author Alexis Deslandes
**/
public class LanceurClient {

    public static void main(String[] args) throws UnknownHostException, RemoteException, NotBoundException, MalformedURLException {
        String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ServeurDistantInterface";
        ServeurDistantInterface serverDistant = (ServeurDistantInterface) Naming.lookup(url);
        InterfaceClient client = new Client();
        serverDistant.abonne(client);
        System.out.println("Si vous voulez vous deconnecter, tapez 0");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String ligne = scanner.nextLine();
            if (ligne.equals("0")){
                serverDistant.desabonne(client);
                break;
            }
        }
    }

}
