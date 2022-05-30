import java.net.*;
import java.awt.AWTException;
import java.io.*;

public class Server {
    MouseDestination md = null;

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    public Server(int port) {
        try {
            md = new MouseDestination();
        } catch (AWTException e) {

            e.printStackTrace();
        }
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            int x = 0;
            int y = 0;
            String line="";
            while (true) {
                try {
                    line=in.readUTF();
                    x = Integer.parseInt(line.split(" ")[0]);
                    y = Integer.parseInt(line.split(" ")[1]);
                   // md.setMouse(x, y);
                    System.out.println(x + " " + y);

                } catch (IOException i) {
                    System.out.println(i);
                    break;
                }
            }
            System.out.println("Closing connection");

            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

}