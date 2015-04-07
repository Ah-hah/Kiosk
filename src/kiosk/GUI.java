package kiosk;
//Import packages

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

//Main class

public class GUI{

    //Declare variables

    static JFrame frame;

    static Container pane;

    static JButton btnConnect, btnDisconnect;

    static JLabel lblServer, lblUsername, lblPassword, lblPort;
    static JTextField txtServer, txtUsername, txtPassword, txtPort;

    static Insets insets;

    public static void main (String args[]){

        //Set Look and Feel

        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}

        catch (ClassNotFoundException e) {}

        catch (InstantiationException e) {}

        catch (IllegalAccessException e) {}

        catch (UnsupportedLookAndFeelException e) {}

        //Create the frame

        frame = new JFrame ("Kiosk");

        frame.setSize (600,600);

        pane = frame.getContentPane();

        insets = pane.getInsets();

        pane.setLayout (null);

 
      //Create controls

        btnConnect = new JButton ("Connect");
        btnDisconnect = new JButton ("Disconnect");
        lblServer = new JLabel ("Remote host:");
        lblPassword = new JLabel ("Password:");
        lblPort = new JLabel ("Port #:");
        txtServer = new JTextField (10);

        //Add all components to panel
        pane.add (lblServer);
        pane.add (lblUsername);
        pane.add (lblPassword);

        pane.add (lblPort);

        pane.add (txtServer);
        pane.add (btnConnect);

        pane.add (btnDisconnect);


        //Place all components

        lblServer.setBounds (insets.left + 5, insets.top + 5, lblServer.getPreferredSize().width, lblServer.getPreferredSize().height);

        txtServer.setBounds (lblServer.getX() + lblServer.getWidth() + 5, insets.top + 5, txtServer.getPreferredSize().width, txtServer.getPreferredSize().height);

        lblUsername.setBounds (txtServer.getX() + txtServer.getWidth() + 5, insets.top + 5, lblUsername.getPreferredSize().width, lblUsername.getPreferredSize().height);

        btnDisconnect.setBounds (insets.left + 15, lblServer.getY() + lblServer.getHeight() + 5, btnDisconnect.getPreferredSize().width, btnDisconnect.getPreferredSize().height);

 

        //Set frame visible
        frame.setVisible (true);
        //center the window
        frame.setLocationRelativeTo(null);
        //Button's action

        btnConnect.addActionListener(new btnConnectAction()); //Register action

    }

 

    public static class btnConnectAction implements ActionListener{

        public void actionPerformed (ActionEvent e){

            System.out.println("You entered "+txtUsername.getText());

        }
}

}
