import ChatHandler.*;;

/**
 * UI
 */
public class Chat {

    public static void main(String[] args) 
    throws Exception
    {
        //MyFrame f = new MyFrame();

        //ClientUI clientUI = new ClientUI();
        //SeverUI severUI = new SeverUI();
        ChatSever newSever = new ChatSever(0);
        newSever.listen();
    }
}