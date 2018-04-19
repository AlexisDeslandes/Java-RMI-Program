import java.rmi.Remote;
import java.rmi.RemoteException;

/**
    @author Alexis Deslandes
**/
interface ServeurDistantInterface extends Remote {

    void abonne(InterfaceClient interfaceClient) throws RemoteException;
    void desabonne(InterfaceClient interfaceClient) throws RemoteException;

}
