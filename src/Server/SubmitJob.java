/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

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
    public String message;
    public String cluster;

    public void findXRSLFile(BufferedReader reader, PrintWriter writer) throws IOException {

        System.out.println("start");

            fileNameXRSL = reader.readLine();
            System.out.println(fileNameXRSL);
            if (fileNameXRSL != null) {

//                System.out.println("head /home/"+Login.user.getUserName()+"/"+fileNameXRSL);
//                String command = ("head /home/"+Login.user.getUserName()+"/"+fileNameXRSL);
//                SubmitJob submitJob = new SubmitJob();
//                String result  = submitJob.actionExecute(command);
                String result= new String(Files.readAllBytes(Paths.get("/home/"+Login.user.getUserName()+"/"+fileNameXRSL)));

                writer.write(result);
                writer.flush();
                writer.close();
                System.out.println(result);
            } else {
                String result = "no such file";
                writer.write(result);
                writer.flush();
                writer.close();
            }

        }



    
    public void submitJob(BufferedReader reader, PrintWriter writer) throws IOException {
                    cluster = reader.readLine();
                    fileNameXRSL=reader.readLine();
                    System.out.println("arcsub -c "+cluster+" "+fileNameXRSL);
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.SubmitJobFile(Login.user.getUserName(), cluster, fileNameXRSL);
        String command = ("./SubmitJobFile"+Login.user.getUserName()+".sh" );
        SubmitJob submitJob = new SubmitJob();
        String result = submitJob.actionExecute(command);
        writer.write(result);
        writer.flush();

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
    private String actionExecute(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            reader.close();
            System.out.println("finish record");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
