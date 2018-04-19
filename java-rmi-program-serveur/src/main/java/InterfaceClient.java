import java.rmi.Remote;
import java.rmi.RemoteException;

/**
    @author Alexis Deslandes
**/
public interface InterfaceClient extends Remote {

    void receptionne(String message) throws RemoteException;

}
