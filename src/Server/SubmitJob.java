/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import services.ActionExecute;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yana
 */
public class SubmitJob {

    public String fileNameXRSL;
    public String cluster;

    public void findXRSLFile(DataInputStream reader, DataOutputStream writer, Socket socket) throws IOException {

        System.out.println("start");
        ArrayList<String> list = new ArrayList<>();

            fileNameXRSL = reader.readUTF();
            System.out.println(fileNameXRSL);
            if (fileNameXRSL != null) {
                String result= new String(Files.readAllBytes(Paths.get("/home/"+Login.user.getUserName()+"/"+fileNameXRSL)));
                list.add(result);
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(list);
                System.out.println("finish record");
            } else {
                String result = "no such file";
                writer.writeUTF(result);
            }

        }



    
    public void submitJob(DataInputStream reader, Socket socket) throws IOException {
                    cluster = reader.readUTF();
                    fileNameXRSL=reader.readUTF();
                    System.out.println("arcsub -c "+cluster+" "+fileNameXRSL);
        String command = ("arcsub -c "+cluster+" "+fileNameXRSL );
        new ActionExecute(command, socket);

        Runtime.getRuntime().exec("rm SubmitJobFile"+Login.user.getUserName()+".sh");


    }

   public void listOfFiles(Socket socket) throws IOException {
       List<String> results = new ArrayList<>();


       File[] files = new File("/home/"+Login.user.getUserName()+"").listFiles();
       //If this pathname does not denote a directory, then listFiles() returns null.

       for (File file : files) {
           if (file.isFile()&&file.getName().endsWith(".xrsl")) {
               results.add(file.getName());
           }
       }

       ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
       objectOutput.writeObject(results);
       System.out.print("send list");

   }

}
