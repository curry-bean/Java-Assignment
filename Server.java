import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RemoteInterface {
    public static void main(String[] args) {
        try {
            // Create an instance of the server object
            Server obj = new Server();
            // Export the server object to the RMI runtime
            RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject(obj, 0);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RemoteInterface", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public String sayHello() throws RemoteException {
        return "Hello, world!";
    }
}

interface RemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}
