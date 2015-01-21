/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import static Pages.LoginPage.profilePage;
import Pages.ProfilePage;
import grid_node.Main;
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

