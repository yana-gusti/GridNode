/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author yana
 */
public class SubmitJob {
    
    public static String fileNameXRSL;
    public static String everything;
    public static String textArea;
    public static String cluster;
    
    public static void FindXRSLFile(Socket s) throws IOException, ClassNotFoundException {
         ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    fileNameXRSL = titleList.get(0);
                    System.out.println(fileNameXRSL);
                    
                     BufferedReader br = new BufferedReader(new FileReader(fileNameXRSL));
                           try {
                              StringBuilder sb = new StringBuilder();
                              String line = br.readLine();

                              while (line != null) {
                              sb.append(line);
                              sb.append(System.lineSeparator());
                              line = br.readLine();
                              }
                              everything= sb.toString();
                             System.out.println(everything);
                            } finally {
                             br.close();
                             }
                    
                ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, everything);
                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(my);
        
    }
    
    public static void SubmitJob(Socket socket) throws IOException, ClassNotFoundException {
          ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    cluster = titleList.get(0);
                    fileNameXRSL=titleList.get(1);
                    System.out.println("arcsub -c "+cluster+" "+fileNameXRSL);
        String s = null;
       try {
            Process p = Runtime.getRuntime().exec("arcsub -c "+cluster+" "+fileNameXRSL);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((s = stdInput.readLine()) != null) {
                textArea=s+ "\n";
            }
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                textArea=s+ "\n";
            }   
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
        ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, textArea);
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(my);
    }

   
}
