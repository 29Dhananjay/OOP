import java.io.File;
/**
 * Class to initialize web server instances.
 * @author Dhananjay Saikumar
 */
public class WebServerMain {
    /**
     * initializing the web server.
     * @param args args[0] and args[1] are the user directory and the server's port number respectively.
     */
    public static void main(String[] args) {
        // Usage error if the form of imput is incorrect.
        if ((args.length <= 0) && (args.length < 2)) {
            System.out.println("Usage: java WebServerMain <document_root> <port>");
        // Invalid directory error.
        } else if (!new File(args[0]).isDirectory()) {
            System.out.println("There is no directory called: " + args[0]);
        // Invalid portnumber error.
        } else if ((Integer.parseInt(args[1]) <= 1)) {
            System.out.println(args[1] + " is an invalid PortNumber");
        // Creating a webserver instance if all the required parameters are valid.
        } else if (new File(args[0]).isDirectory() && (Integer.parseInt(args[1]) > 1)) {
            new WebServer(args[0], Integer.parseInt(args[1]));
        }
    }
}
