package ChatHandler;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.sound.midi.Receiver;

import UI.SeverUI;

public class ChatSever {
    private SeverUI newSever;
    private int port;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner sc = new Scanner(System.in);

    public ChatSever(int port) {
        this.port = port;
    }

    public void listen(int port)
    {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server is listening on port " + port);
            
            clientSocket = serverSocket.accept();
            System.out.println("Connected");


            out = new PrintWriter(clientSocket.getOutputStream());   
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread sender = new Thread(new Runnable() {
                String msg; //will contain data by Sever
                @Override //override method
                public void run()
                {
                    while(true)
                    {
                        msg = sc.nextLine();
                        out.println(msg);
                        out.flush();
                    }

                }
            });

            sender.start();

            Thread receive = new Thread(new Runnable() 
            {
               String msg;
               @Override
               public void run()
               {
                    try {
                        msg = in.readLine(); //read data from the client socket
                        //While client still connect to the sever
                        while (msg!= null) {
                            System.out.println("Client: " + msg);
                            msg = in.readLine(); // repeat
                        }
    
                        // if msg null mean client disconnect
                        System.out.println("Client Disconnect");
                        //close socket and stream
                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                        
                    } catch (IOException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
               }
            });

            receive.start();
        } 
        catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            //Print prints several lines in the output console
            ex.printStackTrace();
        }


    }
}