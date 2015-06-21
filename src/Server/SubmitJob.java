/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yana
 */
public class SubmitJob {
    
    public static String fileNameXRSL;
    public static String message;
    public static String textArea;
    public static String cluster;
    
    public static void FindXRSLFile(Socket s) throws IOException, ClassNotFoundException {
        System.out.println("start");
         ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());
        System.out.println("1");
        if(objectInput!=null) {
            System.out.println("2");
            Object object = objectInput.readObject();
            System.out.println("3");
            titleList = (ArrayList<String>) object;
            System.out.println("4");
            fileNameXRSL = titleList.get(0);
            System.out.println(fileNameXRSL);
            if (fileNameXRSL != null) {
                message = new Scanner( new File("/home/"+Login.user.getUserName()+"/"+fileNameXRSL+"") ).useDelimiter("\\A").next();

//                String[] command = {"xterm", "cat /home/" + Login.user.getUserName() + "/" + fileNameXRSL + ""};
//                System.out.println(command[1]);
//                Process child = Runtime.getRuntime().exec(command);

//               BufferedReader br = new BufferedReader(new InputStreamReader(child.getInputStream()));
//
//                while ((everything = br.readLine()) != null) {
//                    System.out.println(everything);
//                }
                System.out.println(message);

//                br.close();
            } else {
                System.out.println("no such file");
            }
        }else {
            System.out.println("connection not establish");
        }

    }
    
    public static void SubmitJob(Socket socket) throws IOException, ClassNotFoundException {
          ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    cluster = titleList.get(0);
                    fileNameXRSL=titleList.get(1);
                    System.out.println("arcsub -c "+cluster+" "+fileNameXRSL);
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.SubmitJobFile(Login.user.getUserName(), cluster, fileNameXRSL);
        String s = null;
       try {
           String[] command = { "xterm", "./SubmitJobFile"+Login.user.getUserName()+".sh" };
           Process p =Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                message=s+ "\n";
            }
            // read any errors from the attempted command
           System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                message=s+ "\n";
            }   
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }

        Runtime.getRuntime().exec("rm SubmitJobFile"+Login.user.getUserName()+".sh");
    }

   public static void listOfFiles(String userName, Socket socket) throws IOException {
       List<String> results = new ArrayList<String>();


       File[] files = new File("/home/"+userName+"").listFiles();
       //If this pathname does not denote a directory, then listFiles() returns null.

       for (File file : files) {
           if (file.isFile()&&file.getName().endsWith(".xrsl")) {
               results.add(file.getName());
           }
       }

       ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
       objectOutput.writeObject(results);

   }
}
