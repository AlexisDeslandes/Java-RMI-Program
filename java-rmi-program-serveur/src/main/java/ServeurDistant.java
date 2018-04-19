import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
    @author Alexis Deslandes
**/
public class ServeurDistant extends UnicastRemoteObject implements ServeurDistantInterface {

    ServeurDistant() throws RemoteException {
        super();
    }

    @Override
    public void abonne(InterfaceClient interfaceClient) throws RemoteException {
        Serveur.getINSTANCE().recoieAbonnement(interfaceClient);
    }

    @Override
    public void desabonne(InterfaceClient interfaceClient) throws RemoteException {
        Serveur.getINSTANCE().recoieDesabonnement(interfaceClient);
    }
}
