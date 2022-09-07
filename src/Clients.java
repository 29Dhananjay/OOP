import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
/**
 * Clients associated to threads.
 * @author Dhananjay Saikumar
 */
public class Clients extends Thread {
    private String directory;
    private Socket socketConnection;
    private String userRequest;
    /**
     * Socket and directory as parameters.
     * @param directory directory.
     * @param socketConnection socket.
     */
    public Clients(String directory, Socket socketConnection) {
        this.directory = directory;
        this.socketConnection = socketConnection;
        try {
            // Obtaining user request as a single line.
            userRequest = new BufferedReader(new InputStreamReader(socketConnection.getInputStream())).readLine();
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
    }
    /**
     * Extending the thread class.
     * This allows each thread to deal with one client connection.
     */
    public void run() {
        // Initiates a new controller object for a particular client
        try {
            new Controller(this.directory, this.socketConnection, userRequest);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            try {
                socketConnection.close();
                }
                catch (IOException iOException) {
                System.out.println(iOException.getMessage());
            }
        }
    }
}
