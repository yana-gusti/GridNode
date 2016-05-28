package services;


import Server.ServerMain;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by yana on 5/28/16.
 */
public class ResultOfJob {
    public int BUFFER_SIZE = 10000;
    String message;
    ObjectOutputStream objectOutput;
    Integer number=1;
    String folderName;
    File file;


    public void MakeResultOfJob(Socket socket, DataInputStream reader, DataOutputStream writer) throws IOException {
        String jobName;
        jobName = reader.readUTF();
        String result = new ActionExecute("arcget "+jobName+"", socket).output.toString();
        if (result.contains("Results stored at: ")){
            Pattern pnumber = Pattern.compile("successfully cleaned: (.*)");
            Matcher mnumber = pnumber.matcher(result);
            mnumber.find();
            number = Integer.valueOf(mnumber.group(1));
            System.out.println(number);
            for (int i=1; i <=number; i++) {
                Pattern p = Pattern.compile("Results stored at: (.*)");
                Matcher m = p.matcher(result);
                m.find();
                folderName = m.group(i);
                System.out.println(folderName);
                new ZipHelper().zipDir(folderName, folderName+".zip");
                file = new File(folderName+".zip");
                try {
                    new UploadFile().UploadFile(socket, reader, file);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }else{
            System.out.println("No Jobs");
        }
    }

    public void getResultOfJob(Socket socket, DataOutputStream writer, TextArea textArea, JTextPane ResultTextPane) throws IOException, ClassNotFoundException {
        new CommandExecute().jobActionsWithoutJobName(socket, textArea, ResultTextPane);
        String result=textArea.getText();
        if (result.contains("Results stored at: ")){
            for (int i = 1; i <= number; i++) {
                new DownloadFile().DownloadFile(socket, writer);
            }
        } else {
            System.out.println("No Jobs");
        }

        writer.writeUTF(ServerMain.Action.DISCONNECT.name()); ; // send action
        System.out.println("Log out");
        writer.close();
        socket.close();
    }

    public void downloadResultOfJob(Socket socket, DataInputStream reader) throws IOException {
        try {
            new UploadFile().UploadFile(socket, reader, file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
