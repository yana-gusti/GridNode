/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import Server.*;
import static Server.CreateNewJob.CreateNewSHExecute;
import static Server.CreateNewJob.CreateNewXRSLExecute;
import static Server.Login.*;
import static Server.Registration.*;
import static Server.SaveFile.saveFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import services.Users;

/**
 *
 * @author yana
 */
public class ServerMain {
    public static Socket skt=null;
    public static void main(String args[]){


   
    ServerSocket ss2=null;
    System.out.println("Server Listening......");
    try{
        ss2 = new ServerSocket(9999); // can also use static final PORT_NUM , when defined

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Server error");

    }

    while(true){
        try{
            skt= ss2.accept();
            System.out.println("connection Established");
            UserThread st=new UserThread(skt);
            st.start();

        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }
    
    
//    public static Socket skt; 
//
//     public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
//         ServerSocket myServerSocket = new ServerSocket(9999);
//
//
//             skt = myServerSocket.accept();
//             BufferedReader fromClient = new BufferedReader(new InputStreamReader(skt.getInputStream()));
//             String action = fromClient.readLine();
//
//             System.out.println(action);
//
//
//         while (true) {
//
//             
//          
//
//
//             if (action.equals("login")) {
//                 LoginExecute();
//
//             } else if (action.equals("registr")) {
//                 RegistrationExecute();
//                 
//             }else if (action.equals("createSHFile")) {
//                 CreateNewSHExecute();
//                 
//             }else if (action.equals("createXRSLFile")) {
//                 CreateNewXRSLExecute();
//
//             }
//             else if (action.equals("saveFile")) {
//               saveFile(skt);
//
//             } else if (action.equals("findXRSLFile")) {
//               SubmitJob.FindXRSLFile();
//
//             }else if (action.equals("submitJob")) {
//               SubmitJob.SubmitJob();
//
//             }
//             
//             
//         }
//                     
//             
//             
//             
//            
//                
//
//               
//        }
    }
}
    

