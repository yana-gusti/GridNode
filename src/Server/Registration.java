/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import services.DBConnection;
import services.UserServices;
import services.Users;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static Server.Registration.message;

/**
 *
 * @author yana
 */
public class Registration {
    
    public static Users newUser=null;
    public static String message = null;
    public static String firstName;
    public static String lastName;
    public static String vo;
    public static String username;
    public static String pass;
    public static String configPass;
    public static String userCertName;
    public static String userKeyName;
    
    public static void RegistrationExecute(BufferedReader reader, PrintWriter writer) throws IOException{

        firstName = reader.readLine();
        lastName = reader.readLine();
        vo = reader.readLine();
        username = reader.readLine();
        pass = reader.readLine();
        userCertName = reader.readLine();
        userKeyName = reader.readLine();

        System.out.println(firstName+"   "+pass+"   "+vo);

                    Users user = Registration(firstName, lastName, vo, username, pass, pass);
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.CreateRegistrationFile(username, userCertName, userKeyName);
                    System.out.println("create file ./Register"+username+".sh");
                    String[] command = { "xterm", "/home/yana/Desktop/GridNode/Register"+username+".sh" };
                    Runtime.getRuntime().exec(command);
                    Runtime.getRuntime().exec("rm Register"+username+".sh");
                    Runtime.getRuntime().exec("rm "+userCertName+"");
                    Runtime.getRuntime().exec("rm "+userKeyName+"");
                    fileCreator.CreateLoginFile(pass);
                    fileCreator.CreateProxyFile(vo, username);
                    Runtime.getRuntime().exec("./Login.sh");
                    Runtime.getRuntime().exec("rm Login.sh");
                    Runtime.getRuntime().exec("rm proxyInit.sh");
            if(user!=null) {
                System.out.println("writing to client: "+message+" "+user.getFirst_name() +"\n"+user.getLast_name() +"\n");
                writer.write(message);
                writer.write(user.getFirst_name()+"\n");
                writer.write(user.getLast_name()+"\n");
                writer.flush();
            }else {
                System.out.println("user=null");
            }
                
    }
    

    
    public static Users Registration ( String _firstName,String _lastName, String vo,
            String username, String _pass, String _passConf){

        for (Integer i = 0; i < UserServices.getAll().size(); i++) {
	if (UserServices.getAll().get(i).getUserName().equals(username)) {
	message = "Sorry, you can't register as "+ username+"\n";
	System.out.println("a");

	}else{
	if (!_pass.equals(_passConf)) {
	message = "Password confirm failed!\n";
	System.out.println("b");

	}else{

        System.out.println("success");
	}
	}
	}
        newUser = new Users(null, _firstName, _lastName, vo, username, _pass);
	DBConnection.save(newUser);
        message = "success registration\n";
        
         return newUser; 
    }

   
    
}
