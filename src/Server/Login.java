/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import static Pages.LoginPage.profilePage;
import Pages.ProfilePage;
import grid_node.Main;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
    public static ArrayList<String> userData;
    
    public static void LoginExecute() throws IOException, ClassNotFoundException{
        
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    name = titleList.get(0);
                    pass = titleList.get(1);
                    System.out.println(name);
                    System.out.println(pass);
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
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
                
                
    }
    

    
    public static void Login (String e_mail, String _pass){
        
           
        if (e_mail != null && _pass != null) {
	user = UserServices.findUser(e_mail, _pass);
            if (user != null) {
            DBConnection.getUser(user);
                System.out.println("jfhKDJKLDFHlgf");
                message ="success";
               
                        
//                try {
            
//            ProcessBuilder builder = new ProcessBuilder("/bin/bash","-c","xterm -e voms-proxy-init -valid 12:0 -voms "+vo.getText()+" -vomses vomses/"+vo.getText()+"");
//            builder.redirectErrorStream(true); // so we can ignore the error stream
//            
//            Process process = builder.start();
//            Thread.sleep(2000);
//             BufferedReader stdInput = new BufferedReader(new 
//                    InputStreamReader(process.getInputStream()));
//
//            BufferedReader stdError = new BufferedReader(new 
//                    InputStreamReader(process.getErrorStream()));
//
//            String s = null;
//            while ((s = stdInput.readLine()) != null) {
//                
//            }
//
//            while ((s = stdError.readLine()) != null) {
//               
//            }
//   
//          } catch (InterruptedException ex) {
//            Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(SubmitJobPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            profilePage=new ProfilePage();
//            profilePage.setVisible(true);
//
//            Main.loginPage.setVisible(false);
            
        
            } else {
		message ="Invalid login or password!";
		return;
		}

            } else {
            message = "Invalid login or password!";
            return;
	}
    }
}

