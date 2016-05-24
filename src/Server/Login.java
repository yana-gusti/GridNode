/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;


import services.DBConnection;
import services.UserServices;
import services.Users;
import Server.UserThread.*;


import java.io.*;

import static Server.UserThread.reader;
import static Server.UserThread.writer;

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
    
    public static void LoginExecute() throws IOException {

        name = reader.readLine();
        pass = reader.readLine();
        vo = reader.readLine();
                    System.out.println(name+"   "+pass+"   "+vo);
                    Users user = Login(name, pass);
                    FileCreator fileCreator = new FileCreator();
                    
                    if (vo==""){
                       fileCreator.CreateProxyFile(name); 
                    } else {
                        fileCreator.CreateVomsProxyFile(vo, name);
                    }
                    fileCreator.CreateLoginFile(pass);
                    Runtime.getRuntime().exec("sudo ./Login.sh");
                   
        if(user!=null) {
            System.out.println("writing to client: "+user.getFirst_name() +"\n"+user.getLast_name() +"\n");
            writer.write("success login\n");
            writer.write(user.getFirst_name()+"\n");
            writer.write(user.getLast_name()+"\n");
            writer.flush();
        }else {
            System.out.println("user=null");
        }
         Runtime.getRuntime().exec("rm Login.sh");
         Runtime.getRuntime().exec("rm proxyInit.sh");
    }
    

    
    public static Users Login (String name, String pass){
        
           
        if (name != null && pass != null) {
	        user = UserServices.findUser(name, pass);
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

