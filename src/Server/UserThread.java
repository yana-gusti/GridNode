/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Server.CreateNewJob.CreateNewSHExecute;
import static Server.CreateNewJob.CreateNewXRSLExecute;
import static Server.Login.LoginExecute;
import static Server.Registration.RegistrationExecute;
import static Server.SaveFile.saveFile;

/**
 *
 * @author yana
 */
public class UserThread extends Thread{
    String action=null;
    BufferedReader  is = null;
    Socket s=null;

    public UserThread(Socket s){
        this.s=s;
    }

    public void run() {
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        action=is.readLine();
        while(action.compareTo("QUIT")!=0){
            
            if (action.equals("login")) {
                 LoginExecute(s);
                 
             } else if (action.equals("registr")) {
                 RegistrationExecute(s);
                 
             }else if (action.equals("createSHFile")) {
                 CreateNewSHExecute(s);
                 
             }else if (action.equals("createXRSLFile")) {
                 CreateNewXRSLExecute(s);

             }
             else if (action.equals("saveFile")) {
               saveFile(s);
               
             } else if (action.equals("findXRSLFile")) {
               SubmitJob.FindXRSLFile(s);
               
             }else if (action.equals("submitJob")) {
               SubmitJob.SubmitJob(s);

             }
           
             System.out.println("connection reset2");
            s.setKeepAlive(true);
            System.out.println("connection reset 4");
            action=is.readLine();
             System.out.println("connection reset 5");
            s.setKeepAlive(true);
             System.out.println("connection reset3");
            
        }   
    } catch (IOException e) {

        action=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+action+" terminated abruptly");
    }
    catch(NullPointerException e){
        action=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+action+" Closed");
    }   catch (ClassNotFoundException ex) {
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
