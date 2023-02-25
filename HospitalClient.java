import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HospitalClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8000);
        System.out.println("Connected to server");
        
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        
        try {
            // Send a request to the server
            Object request = "Request";
            outputStream.writeObject(request);
            outputStream.flush();
            System.out.println("Sent request: " + request);
            
            // Receive response from the server
            String response = (String) inputStream.readObject();
            System.out.println("Received response: " + response);
        } finally {
            socket.close();
            System.out.println("Disconnected from server");
        }
    }

}
