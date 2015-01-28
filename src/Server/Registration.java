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
                    lastName = titleList.get(1);
                    birthday = titleList.get(2);
                    email = titleList.get(3);
                    pass = titleList.get(4);
                    configPass = titleList.get(5);
                    
                    Users user = Registration(firtsName, lastName, birthday, email, pass, pass);
                    
                String first_name = user.getFirst_name();
                String last_name = user.getLast_name();
                String birthday = user.getBirthday();
                String email = user.getE_mail();
                System.out.println(first_name+last_name+birthday+email);
               
                ArrayList<String> my = new ArrayList<String>();
                
                my.add(0, user.getFirst_name());
                my.add(1, user.getLast_name());
                my.add(2, user.getBirthday());
                my.add(3, user.getE_mail());
                my.add(4, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
                
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
