import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Controller class is used for generating appropriate responses to the user's request.
 * @author Dhananjay Saikumar
 */
public class Controller {
    private Socket socketConnection;
    private PrintWriter pw;
    private InputStream inputStream;
    private OutputStream outputStream;
    private String directory;
    private String userRequest;
    private String fileLocation;
    private File file;
    private String fileExtention = "";
    private boolean fileExists = false;
    private int bit;
    private byte[] arrayBytes = new byte[5000];

    /**
     * Controller object.
     * @param directory target directory.
     * @param socketConnection socket.
     * @param userRequest client request.
     */
    public Controller(String directory, Socket socketConnection, String userRequest) {
        this.directory = directory;
        this.socketConnection = socketConnection;
        this.userRequest = userRequest;
        this.fileLocation = this.directory + userRequest.split("\\s+")[1];
        // Identifies the content type/file type.
        this.file = new File(this.fileLocation);
        if (this.file.exists()) {
            this.fileExists = true;
            if (this.file.getName().contains("jpg")) {
                this.fileExtention = "jpg";
            } else if (this.file.getName().contains("png")) {
                this.fileExtention = "png";
            } else if (this.file.getName().contains("gif")) {
                this.fileExtention = "gif";
            } else if (this.file.getName().contains("html") || this.file.getName().contains("txt")) {
                this.fileExtention = "text/html";
            } else {
                this.fileExtention = "none";
            }
        }
        // Opens up PrintWriter, inputStream and outputStream
        // These are used for writing headers, reading files, and sending files.
        try {
            this.pw = new PrintWriter(this.socketConnection.getOutputStream(), true);
            if (this.fileExists) {
                this.inputStream = new FileInputStream(fileLocation);
                this.outputStream = socketConnection.getOutputStream();
            }
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }

        // Identifies the user request.
        if (fileExists) {
            if (userRequest.contains("HEAD")) {
                headOrGet();
            } else if (userRequest.contains("GET")) {
                headOrGet();
                // File transfer takes place only if the request type = GET.
                fileTransfer();
            } else {
                notImplemented();
                }
            } else {
                error404();
            }
        }
    // response type = HEAD or GET.
    private void headOrGet() {
        pw.println("HTTP/1.1 200 OK\n" + "Server: Simple Java Http Server\n" + "Content-Type: " + fileExtention + "\r\n" + "Content-Length: " + file.length() + "\r\n");
        }
    // response type = not implemented.
    private void notImplemented() {
        pw.println("HTTP/1.1 501 Not Implemented\n" + "Server: Simple Java Http Server\n" + "Content-Type: " + "text/html" + "\r\n" + "Content-Length: " + 0 + "\r\n");
    }
    // response type = 404 error (object/file/request not found).
    private void error404() {
        pw.println("HTTP/1.1 404 Not Found\n" + "Server: Simple Java Http Server\n" + "Content-Type: " + fileExtention + "\r\n" + "Content-Length: " + 0 + "\r\n");
    }
    // Intitates file transfer if the response type = GET.
    private void fileTransfer() {
        try {
            while ((bit = inputStream.read(arrayBytes)) != -1) {
                outputStream.write(arrayBytes, 0, bit);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
    }
}
