/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import static Server.CreateNewJob.CreateNewSHExecute;
import static Server.CreateNewJob.CreateNewXRSLExecute;
import static Server.Login.LoginExecute;
import static Server.Registration.RegistrationExecute;
import static Server.SaveFile.saveFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yana
 */
public class UserThread extends Thread{
     String line=null;
    BufferedReader  is = null;
    PrintWriter os=null;
    Socket s=null;

    public UserThread(Socket s){
        this.s=s;
    }

    public void run() {
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        line=is.readLine();
        while(line.compareTo("QUIT")!=0){
            
             if (line.equals("login")) {
                 os.flush();
                 LoginExecute();
                 os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();

             } else if (line.equals("registr")) {
                 os.flush();
                 RegistrationExecute();
                 os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();
                 
             }else if (line.equals("createSHFile")) {
                 os.flush();
                 CreateNewSHExecute();
                 os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();
                 
             }else if (line.equals("createXRSLFile")) {
                 os.flush();
                 CreateNewXRSLExecute();
                 os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();

             }
             else if (line.equals("saveFile")) {
                 os.flush();
               saveFile(s);
               os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();

             } else if (line.equals("findXRSLFile")) {
                 os.flush();
               SubmitJob.FindXRSLFile();
                 os.flush();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();                
             }else if (line.equals("submitJob")) {
                 os.flush();
               SubmitJob.SubmitJob();
                 System.out.println("Response to Client  :  "+line);
                 line=is.readLine();  
             }

        }   
    } catch (IOException e) {

        line=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+line+" terminated abruptly");
    }
    catch(NullPointerException e){
        line=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+line+" Closed");
    }    catch (ClassNotFoundException ex) {
             Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
         } catch (Exception ex) {
             Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
         }

    finally{    
    try{
        System.out.println("Connection Closing..");
        if (is!=null){
            is.close(); 
            System.out.println(" Socket Input Stream Closed");
        }

        if(os!=null){
            os.close();
            System.out.println("Socket Out Closed");
        }
        if (s!=null){
        s.close();
        System.out.println("Socket Closed");
        }

        }
    catch(IOException ie){
        System.out.println("Socket Close Error");
    }
    }//end finally
    }
    
}
