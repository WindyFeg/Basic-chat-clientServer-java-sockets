package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientUI
        extends JFrame
        implements ActionListener {
    // Variable
    private Container c;
    private JLabel l_title;
    private JLabel l_ipAddress;
    private JLabel l_port;
    private JLabel l_mes;
    private JTextField i_ipaddress;
    private JTextField i_port;
    private JTextField i_message;
    private JTextArea t_message;
    private JButton btnSet;
    private JButton btnSend;

    public ClientUI() {
        // Title
        setTitle("Client Chat");
        // Size
        setBounds(300, 90, 550, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Title
        l_title = new JLabel("Client Chat");
        l_title.setFont(new Font("Arial", Font.PLAIN, 30));
        l_title.setSize(300, 30);
        l_title.setLocation(200, 30);
        c.add(l_title);

        // Ip address label
        l_ipAddress = new JLabel("IP: ");
        l_ipAddress.setFont(new Font("Arial", Font.PLAIN, 20));
        l_ipAddress.setSize(100, 20);
        l_ipAddress.setLocation(50, 100);
        c.add(l_ipAddress);

        // Ip address input
        i_ipaddress = new JTextField();
        i_ipaddress.setFont(new Font("Arial", Font.PLAIN, 12));
        i_ipaddress.setSize(150, 20);
        i_ipaddress.setLocation(100, 100);
        c.add(i_ipaddress);

        l_port = new JLabel("Port: ");
        l_port.setFont(new Font("Arial", Font.PLAIN, 20));
        l_port.setSize(100, 20);
        l_port.setLocation(250, 100);
        c.add(l_port);

        // Ip address input
        i_port = new JTextField();
        i_port.setFont(new Font("Arial", Font.PLAIN, 12));
        i_port.setSize(50, 20);
        i_port.setLocation(300, 100);
        c.add(i_port);

        t_message = new JTextArea();
        t_message.setFont(new Font("Arial", Font.PLAIN, 15));
        t_message.setSize(450, 300);
        t_message.setLocation(50, 150);
        t_message.setLineWrap(true);
        t_message.setEditable(false);
        c.add(t_message);

        // Label message
        l_mes = new JLabel("Message: ");
        l_mes.setFont(new Font("Arial", Font.PLAIN, 20));
        l_mes.setSize(100, 20);
        l_mes.setLocation(50, 475);
        c.add(l_mes);

        // input message
        i_message = new JTextField();
        i_message.setFont(new Font("Arial", Font.PLAIN, 12));
        i_message.setSize(290, 25);
        i_message.setLocation(150, 475);
        c.add(i_message);

        btnSet = new JButton("SET");
        btnSet.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSet.setSize(80, 40);
        btnSet.setLocation(400, 90);
        btnSet.addActionListener(this);
        c.add(btnSet);

        btnSend = new JButton("S");
        btnSend.setFont(new Font("Arial", Font.BOLD, 20));
        btnSend.setSize(60, 40);
        btnSend.setLocation(450, 465);
        btnSend.addActionListener(this);
        c.add(btnSend);

        // Set visible to see the damn thing
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
