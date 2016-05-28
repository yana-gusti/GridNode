package services;

import Server.ServerMain;
import org.omg.CORBA.Principal;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by yana on 5/28/16.
 */
public class CommandExecute implements Serializable {
    private static final long serialVersionUID = 1L;
    public void jobActionsWithJobName (DataOutputStream writer, Socket s, TextArea textArea, JTextPane ResultTextPane) throws IOException {

        textArea.setText("");
        String jobName= JOptionPane.showInputDialog("Enter job name");
        if (jobName != null ) {
            writer.writeUTF(jobName);
            System.out.println("send "+jobName);
            ArrayList<String> outputList;
            try {
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream()); //Error Line!
                try {
                    Object object = objectInput.readObject();
                    outputList =  (ArrayList<String>) object;

                    for (int i=0; i<outputList.size(); i++){
                        textArea.append(outputList.get(i));

                    }
                    ResultTextPane.setText(textArea.getText());
                } catch (ClassNotFoundException e) {
                    System.out.println("The title list has not come from the server");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("The socket for reading the object has problem");
                e.printStackTrace();
            }
            writer.writeUTF(ServerMain.Action.DISCONNECT.name()); ; // send action
            System.out.println("Log out");
            writer.close();
            s.close();
        }else {
            ResultTextPane.setText("Please, enter job name");
        }

    }

    public void jobActionsWithoutJobName (Socket s, TextArea textArea, JTextPane ResultTextPane) throws IOException {
        textArea.setText("");
            ArrayList<String> outputList;
            try {
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream()); //Error Line!
                try {
                    Object object = objectInput.readObject();
                    outputList =  (ArrayList<String>) object;

                    for (int i=0; i<outputList.size(); i++){
                        textArea.append(outputList.get(i));

                    }
                    ResultTextPane.setText(textArea.getText());
                } catch (ClassNotFoundException e) {
                    System.out.println("The title list has not come from the server");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("The socket for reading the object has problem");
                e.printStackTrace();
            }


    }
}
