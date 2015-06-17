/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import services.DBConnection;
import services.UserServices;
import services.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author yana
 */
public class Registration {
    
    public static Users newUser=null;
    public static String message = null;
    public static String firtsName;
    public static String lastName;
    public static String vo;
    public static String email;
    public static String pass;
    public static String configPass;
    public static String userCertName;
    public static String userKeyName;
    public static ArrayList<String> userData;
    
    public static void RegistrationExecute(Socket s) throws IOException, ClassNotFoundException, InterruptedException{
        
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());

                
                    Object object = objectInput.readObject();
                    System.out.println("get data from client");
                    titleList = (ArrayList<String>) object;
                    firtsName = titleList.get(0);
                    lastName = titleList.get(1);
                    vo = titleList.get(2);
                    email = titleList.get(3);
                    pass = titleList.get(4);
                    configPass = titleList.get(5);
                    userCertName = titleList.get(6);
                    userKeyName = titleList.get(7);
                    Users user = Registration(firtsName, lastName, vo, email, pass, pass);
                    System.out.println("register new user");
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.CreateRegistrationFile(email, userCertName, userKeyName);
                    System.out.println("create file ./Register"+email+".sh");
                    String[] command = { "xterm", "/home/yana/Desktop/GridNode/Register"+email+".sh" };
                    Runtime.getRuntime().exec(command);
                    Thread.sleep(5000);
                    Runtime.getRuntime().exec("rm Register"+email+".sh");
                    Runtime.getRuntime().exec("rm "+userCertName+"");
                    Runtime.getRuntime().exec("rm "+userKeyName+"");
                    fileCreator.CreateLoginFile(pass);
                    fileCreator.CreateProxyFile(vo, email);
                    Runtime.getRuntime().exec("./Login.sh");
                    Runtime.getRuntime().exec("rm Login.sh");
                    Runtime.getRuntime().exec("rm proxyInit.sh");
            if(user!=null) {
                ArrayList<String> my = new ArrayList<String>();

                my.add(0, user.getFirst_name());
                my.add(1, user.getLast_name());
                my.add(2, user.getVO());
                my.add(3, user.getE_mail());
                my.add(4, message);

                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(my);
            }
                
    }
    

    
    public static Users Registration ( String _firstName,String _lastName, String _birthday,
            String _email, String _pass, String _passConf){

        for (Integer i = 0; i < UserServices.getAll().size(); i++) {
	if (UserServices.getAll().get(i).getE_mail().equals(_email)) {
	message = "Sorry, you can't registr as "+ _email+"";
	System.out.println("a");

	}else{
	if (!_pass.equals(_passConf)) {
	message = "Password confirm failed!";
	System.out.println("b");

	}else{
        System.out.println("success");
         

         
	}
	}
	}
        newUser = new Users(null, _firstName, _lastName, _birthday, _email, _pass);
	System.out.println("qqq");
	DBConnection.save(newUser);
        System.out.println("jfhKDJKLDFHlgf");
         message ="success";
        
         return newUser; 
    }

   
    
}
