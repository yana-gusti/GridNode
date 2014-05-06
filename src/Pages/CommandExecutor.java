/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import static Pages.SubmitJobPage.isAlive;
    import java.io.BufferedReader;
    import java.io.IOException;
import java.io.InputStream;
    import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class CommandExecutor {
    public static String execute(String command){
        StringBuilder sb = new StringBuilder();
        String[] commands = new String[]{"/bin/sh","-c", command};
        try {
            Process proc = new ProcessBuilder(commands).start();
            BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(proc.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }

            while ((s = stdError.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

   
        try {
            
            ProcessBuilder builder = new ProcessBuilder("xterm","arcproxy");
            builder.redirectErrorStream(true); // so we can ignore the error stream
            
            Process process = builder.start();
            Thread.sleep(2000);
            InputStream out = process.getInputStream();
            OutputStream in = process.getOutputStream();
             BufferedReader stdInput = new BufferedReader(new 
                    InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                    InputStreamReader(process.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            while ((s = stdError.readLine()) != null) {
               System.out.println(s);
            }
                byte[] buffer = new byte[4000];
    while (isAlive(process)) {
      int no = out.available();
      if (no > 0) {
        int n = out.read(buffer, 0, Math.min(no, buffer.length));
         System.out.println(new String(buffer, 0, n));
         textArea.append(new String(buffer, 0, n)+ "\n");
      }

      int ni = System.in.available();
      if (ni > 0) {
          buffer.toString();
        int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
        in.write(buffer, 0, n);
        in.flush();
        
      }

      try {
        Thread.sleep(2000);
      }
      catch (InterruptedException e) {
      }
    }

    System.out.println(process.exitValue());
////              Process p = Runtime.getRuntime().exec("voms-proxy-init -voms "+VO+" -valid 48:00");
//           String command= "/usr/bin/xterm"; 
//    	Runtime rt = Runtime.getRuntime(); 	
//    	Process pr = rt.exec(command);
//            Process p = Runtime.getRuntime().exec("/bin/bash -c voms-proxy-init \n\nIana.gusti246897531");
//            Process p = Runtime.getRuntime().exec("java -jar /home/yana/NetBeansProjects/HelloWorld/dist/Hello_World.jar");
                
//            System.out.println("qwerttrghfh");
//
//            BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            BufferedReader stdError1 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//             while ((s = stdInput1.readLine()) != null) {
//               
//                textArea.append(s+ "\n");
//                
//            }
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError1.readLine()) != null) {
//                textArea.append(s+ "\n");
//                
//            }
//            
//            
            
            
            
            
            
            
            
//          Process q = Runtime.getRuntime().exec("ngsub "+XRSLFile.getName());  
//            Process q = Runtime.getRuntime().exec("ping -c 3 cisco.com");
            
//            BufferedReader stdInput2 = new BufferedReader(new InputStreamReader(q.getInputStream()));
            
//            BufferedReader stdError2 = new BufferedReader(new InputStreamReader(q.getErrorStream()));
            // read the output from the command

//            while ((s = stdInput2.readLine()) != null) {
//                textArea.append(s+ "\n");
//                ResultPanel.setText(textArea.getText());
//            }
            // read any errors from the attempted command
            
//            while ((s = stdError2.readLine()) != null) {
//                textArea.append(s+ "\n");
//                ResultPanel.setText(textArea.getText());
//            }
            
           
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
        }


}