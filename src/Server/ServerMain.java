/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

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
    public static String message;
    public static String name;
    public static String pass;
    public static ArrayList<String> userData;
     public static void main(String[] args) throws IOException, ClassNotFoundException {
        
            ServerSocket myServerSocket = new ServerSocket(9999);
            Socket skt = myServerSocket.accept();
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    name = titleList.get(0);
                    pass = titleList.get(1);
                    System.out.println(name);
                    System.out.println(pass);

//                    if(name.equals("q")&&pass.equals("w")){
//                        System.out.println("Success");
                    Users user =null;
                    Login.Login(name, pass);
                    message = Login.message;
                    
                String first_name = Login.user.getFirst_name();
                String last_name = Login.user.getLast_name();
                String birthday = Login.user.getBirthday();
                String email = Login.user.getE_mail();
                System.out.println(first_name+last_name+birthday+email);
               
                ArrayList<String> my = new ArrayList<String>();
                
                my.add(0, Login.user.getFirst_name());
                my.add(1, Login.user.getLast_name());
                my.add(2, Login.user.getBirthday());
                my.add(3, Login.user.getE_mail());
                my.add(4, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(skt.getOutputStream());
                objectOutput.writeObject(my);
                
//                PrintWriter toClient = new PrintWriter(skt.getOutputStream(), true);
//                toClient.println(message);
               
        }
    }
    

