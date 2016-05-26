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

/**
 *
 * @author yana
 */
public class Login {
    public static Users user=null;
    public  String message = null;
    public  String name;
    public  String pass;
    public  String vo;

    public void LoginExecuteWithoutVO(BufferedReader reader, PrintWriter writer) throws IOException {

        name = reader.readLine();
        pass = reader.readLine();
        System.out.println(name+"   "+pass+"   ");
        Users user = Login(name, pass);

        if(user!=null) {
            FileCreator fileCreator = new FileCreator();
            fileCreator.CreateProxyFile(name);
            fileCreator.CreatePassFile(pass);
            String command = "./proxyInit.sh";
            JobActions jobActions = new JobActions();
            String result = jobActions.actionExecute(command);
            System.out.println(result);
            System.out.println("writing to client: "+user.getFirst_name() +"\n"+user.getLast_name() +"\n");
            writer.write("success login\n");
//            writer.write(user.getFirst_name()+"\n");
//            writer.write(user.getLast_name()+"\n");
            writer.flush();
        }else {
            writer.write("no such user\n");
            System.out.println("user=null");
            writer.flush();
        }
//         Runtime.getRuntime().exec("rm pass.txt");
//         Runtime.getRuntime().exec("rm proxyInit.sh");
    }
    
    public void LoginExecute(BufferedReader reader, PrintWriter writer) throws IOException {

        name = reader.readLine();
        pass = reader.readLine();
        vo = reader.readLine();
                    System.out.println(name+"   "+pass+"   "+vo);
                    Users user = Login(name, pass);

//                    Runtime.getRuntime().exec("sudo ./Login.sh");
                   
        if(user!=null) {
            FileCreator fileCreator = new FileCreator();
            fileCreator.CreateVomsProxyFile(vo, name);
            fileCreator.CreatePassFile(pass);
            String command = "echo 1 | sudo -S -k bash /home/yana/Desktop/GridNode/proxyInit.sh";
            JobActions jobActions = new JobActions();
            String result = jobActions.actionExecute(command);
            System.out.println(result);
            System.out.println("writing to client: "+user.getFirst_name() +"\n"+user.getLast_name() +"\n");
            writer.write("success login\n");
//            writer.write(user.getFirst_name()+"\n");
//            writer.write(user.getLast_name()+"\n");
            writer.flush();
        }else {
            writer.write("no such user\n");
            writer.flush();
            System.out.println("user=null");
        }
         Runtime.getRuntime().exec("rm pass.txt");
         Runtime.getRuntime().exec("rm proxyInit.sh");
    }
    

    
    public Users Login (String name, String pass){
        
           
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

