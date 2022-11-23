package ChatHandler;

import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket serverSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void Set(String host, int port) {
        try {
            serverSocket = new Socket(host, port);
            
             // Get input of client through client socket
            // Send msg to client through output 
            out = new PrintWriter(serverSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

            System.out.println("Connected");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Send(String uiMsg) {
        String msg; // will contain data by Sever
        msg = uiMsg; // nextLine will pause exc
        out.println(msg);
        out.flush();
    }

    public String receive() {
        String msg;
        try {
            msg = in.readLine(); // read data from the client socket

            if(msg != null) {
                System.out.println("Server: " + msg);
                return "Server: " + msg;
            }

            // if msg null mean client disconnect
            // close socket and stream
            out.close();
            serverSocket.close();
            System.out.println("Client Disconnect");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Disconnect from sever";

    }

}
