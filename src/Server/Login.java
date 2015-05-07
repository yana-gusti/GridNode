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
    public static ArrayList<String> userData;
    
    public static void LoginExecute() throws IOException, ClassNotFoundException{
        
            ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    name = titleList.get(0);
                    pass = titleList.get(1);
                    System.out.println(name+"   "+pass);
                    Users user =Login(name, pass);
                    
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



//                ProxyCertInfo info = new ProxyCertInfo()
//
//                GlobusProxyCertInfoExtension proxy = new GlobusProxyCertInfoExtension()
               
                        
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

		}

            } else {
            message = "Invalid login or password!";

	}
        return user;
    }


}

