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
public class Login {
    public static Users user=null;
    public static String message = null;
    public static String name;
    public static String pass;
    public static String vo;
    public static ArrayList<String> userData;
    
    public static void LoginExecute() throws IOException, ClassNotFoundException{
        
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    name = titleList.get(0);
                    pass = titleList.get(1);
                    vo = titleList.get(2);
                    System.out.println(name+"   "+pass+"   "+vo);
                    Users user =Login(name, pass);
                    FileCreator fileCreator = new FileCreator();
                    fileCreator.CreateLoginFile(pass);
                    fileCreator.CreateProxyFile(vo);
                    Runtime.getRuntime().exec("./Login.sh");
                    
                     System.out.println("fedfdsfsdf");
               
                ArrayList<String> my = new ArrayList<String>();
                
                my.add(0, user.getFirst_name());
                my.add(1, user.getLast_name());
                my.add(2, user.getBirthday());
                my.add(3, user.getE_mail());
                my.add(4, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
                
                
    }
    

    
    public static Users Login (String e_mail, String _pass){
        
           
        if (e_mail != null && _pass != null) {
	        user = UserServices.findUser(e_mail, _pass);
            if (user != null) {
            DBConnection.getUser(user);
                message ="success";
        
            } else {
		message ="Invalid login or password!";

		}

            } else {
            message = "Invalid login or password!";

	}
        return user;
    }


}

