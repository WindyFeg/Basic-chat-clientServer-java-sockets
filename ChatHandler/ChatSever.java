package ChatHandler;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatSever {
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    // Read input from key board
    private Scanner sc = new Scanner(System.in);

    public ChatSever(int port) {
        this.port = port;
    }

    public void listen(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server is listening on port " + port);
            // Waiting for client
            clientSocket = serverSocket.accept(); // this is client
            System.out.println("Connected\n");
            System.out.println("Now you can chat each other!\n");

            // Get output of client through client socket
            out = new PrintWriter(clientSocket.getOutputStream());
            //
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // 2 thread 1 loop on waiting, other stop exc at System.in
            // receive();
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            // Print prints several lines in the output console
            ex.printStackTrace();
        }
    }

    public String receive() {
        String msg;
        try {
            msg = in.readLine(); // read data from the client socket
            // While client still connect to the sever
            if(msg != null) {
                System.out.println("Client: " + msg);
                return "Client: " + msg;
            }

            // if msg null mean client disconnect
            // close socket and stream
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Client Disconnect");
            
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "Client Disconnect";

    }

    public void Send(String uiMsg) {

        // Thread sender = new Thread(new Runnable() {
        String msg; // will contain data by Sever
        // @Override //override method
        // public void run()
        // {
        // while(true)
        // {
        // set message from key board tp msg
        msg = uiMsg; // nextLine will pause exc
        out.println(msg);
        out.flush();
        // }

        // }
        // });

        // sender.start();
    }

}