import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        try {
            // Get a reference to the remote registry
            Registry registry = LocateRegistry.getRegistry("localhost");
            // Lookup the remote object from the registry
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteInterface");
            // Call the remote method
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
