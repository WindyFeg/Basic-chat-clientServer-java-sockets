import ChatHandler.*;;

/**
 * UI
 */
public class Chat2 {

    public static void main(String[] args) 
    throws Exception
    {
        //MyFrame f = new MyFrame();

        //ClientUI clientUI = new ClientUI();
        //SeverUI severUI = new SeverUI();
        // ChatSever newSever = new ChatSever(0);
        // newSever.listen(9888);
        ChatClient newclient = new ChatClient();
        newclient.Set("127.0.0.1", 9888);
    }
}