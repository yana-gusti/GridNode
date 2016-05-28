/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;


import Pages.LoginPage;
import services.ActionExecute;
import services.DBConnection;
import services.UserServices;
import services.Users;


import java.io.*;
import java.net.Socket;

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

    public void LoginExecuteWithoutVO(DataInputStream reader, DataOutputStream writer, Socket socket) throws IOException {

        name = reader.readUTF();
        pass = reader.readUTF();
        System.out.println(name+"   "+pass+"   ");
        Users user = Login(name, pass);

        if(user!=null) {
            FileCreator fileCreator = new FileCreator();
            fileCreator.CreateProxyFile(name);
            fileCreator.CreatePassFile(pass);
            String command = "./proxyInit.sh";
            writer.writeUTF(LoginPage.Action.YES.name());
            new ActionExecute(command, socket);
            Runtime.getRuntime().exec("rm pass.txt");
            Runtime.getRuntime().exec("rm proxyInit.sh");
        }else {
            writer.writeUTF(LoginPage.Action.NO.name());
            System.out.println("user=null");
        }

    }
    
    public void LoginExecute(DataInputStream reader, DataOutputStream writer, Socket socket) throws IOException {

        name = reader.readUTF();
        pass = reader.readUTF();
        vo = reader.readUTF();
        System.out.println(name+"   "+pass+"   "+vo);
        Users user = Login(name, pass);

        if(user!=null) {
            FileCreator fileCreator = new FileCreator();
            fileCreator.CreateVomsProxyFile(vo, name);
            fileCreator.CreatePassFile(pass);
            writer.writeUTF(LoginPage.Action.YES.name());
            String command = "./proxyInit.sh";
            new ActionExecute(command, socket);
            Runtime.getRuntime().exec("rm pass.txt");
            Runtime.getRuntime().exec("rm proxyInit.sh");
        }else {
            writer.writeUTF(LoginPage.Action.NO.name());
            System.out.println("user=null");
        }

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

