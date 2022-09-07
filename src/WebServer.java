import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * web server class used by webservermain to create web server instances.
 * @author Dhananjay Saikumar
 */
public class WebServer {
    /**
     * This webserver with supports multiple clients via multi-threading which is
     * done by extending the thread class, such that each thead can deal with one client each.
     * @param directory directory requested by the user
     * @param portnumber Server's portnumber
     */
    public WebServer(String directory, int portnumber) {
        // Using Try with resources to start a ServerSocket.
        try (ServerSocket serverSocket = new ServerSocket(portnumber);
            ) {
            // The port actively looks for new clients.
            System.out.println("Server active");
            System.out.println("Active port: " + portnumber);
            // The loop is used to initialize the threads as new clients join the server.
            while (true) {
                // Initializing the thread.
                Clients thread = new Clients(directory, serverSocket.accept());
                System.out.println("New client connection");
                // Starts dealing with the client requests.
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
