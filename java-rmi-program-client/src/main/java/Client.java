import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
    @author Alexis Deslandes
**/

public class Client extends UnicastRemoteObject implements InterfaceClient {
    protected Client() throws RemoteException {
        super();
    }

    @Override
    public void receptionne(String message) throws RemoteException {
        System.out.println("Message bien reçu : " + message);
    }
}
