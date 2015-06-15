/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yana
 */
public class SubmitJob {
    
    public static String fileNameXRSL;
    public static String everything;
    public static String textArea;
    public static String cluster;
    
    public static void FindXRSLFile() throws IOException, ClassNotFoundException {
         ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());
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
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
        
    }
    
    public static void SubmitJob() throws IOException, ClassNotFoundException {
          ArrayList<String> titleList = new ArrayList<String>();
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());
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
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
    }

   
}
