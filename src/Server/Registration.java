/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import services.DBConnection;
import services.UserServices;
import services.Users;

/**
 *
 * @author yana
 */
public class Registration {
    
    public static Users newUser=null;
    public static String message = null;
    public static String firtsName;
    public static String lastName;
    public static String birthday;
    public static String email;
    public static String pass;
    public static String configPass;
    public static ArrayList<String> userData;
    
    public static void RegistrationExecute() throws IOException, ClassNotFoundException{
        
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    firtsName = titleList.get(0);
                    lastName = titleList.get(0);
                    birthday = titleList.get(0);
                    email = titleList.get(0);
                    pass = titleList.get(1);
                    configPass = titleList.get(1);
                    Users user =null;
                    Registration(firtsName, lastName, birthday, email, pass, pass);
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
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
    }
    

    
    public static void Registration ( String _firstName,String _lastName, String _birthday,  
            String _email, String _pass, String _passConf){
        for (Integer i = 0; i < UserServices.getAll().size(); i++) {
	if (UserServices.getAll().get(i).getE_mail().equals(_email)) {
	message = "Sorry, you can't registr as "+ _email+"";
	System.out.println("a");
	return;
	}else{
	if (!_pass.equals(_passConf)) {
	message = "Password confirm failed!";
	System.out.println("b");
	return;
	}else{
        newUser = new Users(null, _firstName, _lastName, _birthday, _email, _pass);
	System.out.println("w");
	DBConnection.save(newUser);
        System.out.println("jfhKDJKLDFHlgf");
         message ="success";
	}
	}
	}
           
    }

   
    
}
