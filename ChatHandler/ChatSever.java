package ChatHandler;
import java.io.*;
import java.net.*;
import java.util.*;

import UI.SeverUI;

public class ChatSever 
{
    private SeverUI newSever;
    private int port;
    
    public ChatSever(int port)
    {
        this.port = port;
    }

    public void listen()
    {
        newSever = new SeverUI();
    }
}