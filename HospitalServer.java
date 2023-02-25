import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HospitalServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            
            try {
                // Read data from the client
                Object request = inputStream.readObject();
                System.out.println("Received request: " + request);
                
                // Process the request
                String response = processRequest(request);
                
                // Send response back to the client
                outputStream.writeObject(response);
                outputStream.flush();
                System.out.println("Sent response: " + response);
            } catch (ClassNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                socket.close();
                System.out.println("Client disconnected");
            }
        }
    }
    
    public static String processRequest(Object request) {
        // Process the request and return a response
        return "Response";
    }

}
