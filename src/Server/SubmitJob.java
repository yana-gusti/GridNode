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

import static Server.UserThread.reader;
import static Server.UserThread.socket;
import static Server.UserThread.writer;

/**
 *
 * @author yana
 */
public class SubmitJob {

    public static String fileNameXRSL;
    public static String message;
    public static String textArea;
    public static String cluster;

    public static void findXRSLFile() throws IOException {
        System.out.println("start");

            fileNameXRSL = reader.readLine();
            System.out.println(fileNameXRSL);
            if (fileNameXRSL != null) {

                Scanner scanner = new Scanner( new File("/home/"+Login.user.getUserName()+"/"+fileNameXRSL+"") );
               message = scanner.useDelimiter("\\A").next();
                scanner.close(); // Put this call in a finally block
                System.out.println(message);
                System.out.println("finish record");
            } else {
                message = "no such file";

            }
        writer.write(message);
        writer.flush();
        }



    
    public static void submitJob() throws IOException {
                    cluster = reader.readLine();
                    fileNameXRSL=reader.readLine();
                    System.out.println("arcsub -c "+cluster+" "+fileNameXRSL);
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.SubmitJobFile(Login.user.getUserName(), cluster, fileNameXRSL);
        String result;
       try {
           String[] command = { "xterm", "./SubmitJobFile"+Login.user.getUserName()+".sh" };
           Process p =Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((result = stdInput.readLine()) != null) {
                message=result+ "\n";
            }
            // read any errors from the attempted command
           System.out.println("Here is the standard error of the command (if any):\n");
            while ((result = stdError.readLine()) != null) {
                message=result+ "\n";
            }   
        }
        catch (IOException e) {
            message = "exception happened - here's what I know: ";
            System.out.println(message);
            e.printStackTrace();
        }

        Runtime.getRuntime().exec("rm SubmitJobFile"+Login.user.getUserName()+".sh");
        writer.write(message);
        writer.flush();

    }

   public static void listOfFiles() throws IOException {
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

   }
}
