/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import Pages.RegistrationPage;
import services.ActionExecute;
import services.DBConnection;
import services.UserServices;
import services.Users;

import java.io.*;
import java.net.Socket;


/**
 *
 * @author yana
 */
public class Registration {
    
    public Users newUser=null;
    public String message = null;
    public String firstName;
    public String lastName;
    public String vo;
    public  String username;
    public String pass;
    public String userCertName;
    public String userKeyName;

    
    public void RegistrationExecute(DataInputStream reader, DataOutputStream writer, Socket socket) throws IOException{

        firstName = reader.readUTF();
        lastName = reader.readUTF();
        vo = reader.readUTF();
        username = reader.readUTF();
        pass = reader.readUTF();
        userCertName = reader.readUTF();
        userKeyName = reader.readUTF();
        System.out.println(firstName+"   "+pass+"   "+vo);
        Users user = Registration(firstName, lastName, vo, username, pass);


            if(user!=null) {
                FileCreator fileCreator = new FileCreator();
                fileCreator.CreateRegistrationFile(username, userCertName, userKeyName);
                System.out.println("create file ./Register"+username+".sh");
                String command = "echo 1 | sudo -S -k bash /home/yana/Desktop/GridNode/Register"+username+".sh";
                new ActionExecute(command, socket);
                writer.writeUTF(RegistrationPage.Action.YES.name());
                Runtime.getRuntime().exec("rm Register"+username+".sh");
                Runtime.getRuntime().exec("rm "+userCertName+"");
                Runtime.getRuntime().exec("rm "+userKeyName+"");
            }else {
                System.out.println("Such user is registered");
                writer.writeUTF(RegistrationPage.Action.NO.name());
            }

    }
    

    
    public  Users Registration ( String _firstName,String _lastName, String vo, String username, String _pass){

        for (Integer i = 0; i < UserServices.getAll().size(); i++) {
            if (UserServices.getAll().get(i).getUserName().equals(username)) {
            System.out.println("a");
            }else {
                newUser = new Users(null, _firstName, _lastName, vo, username, _pass);
                DBConnection.save(newUser);
               }
	    }
        return newUser;
    }
}
