/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import Server.*;
import static Server.Login.*;
import static Server.Registration.*;
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
    public static Socket skt; 

     public static void main(String[] args) throws IOException, ClassNotFoundException {
         ServerSocket myServerSocket = new ServerSocket(9999);


             skt = myServerSocket.accept();



         while (true) {

             BufferedReader fromClient = new BufferedReader(new InputStreamReader(skt.getInputStream()));
             String action = fromClient.readLine();

             System.out.println(action);


             if (action.equals("login")) {
                 LoginExecute();

             } else if (action.equals("registr")) {
                 Registration.RegistrationExecute();


             }
         }
                     
             
             
             
            
                

               
        }
    }
    

