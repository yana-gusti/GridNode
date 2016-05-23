/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.net.Socket;


import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author yana
 */
public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        ServerSocket serverSocket = new ServerSocket(7009);

        while(true){
            System.out.println("Stani be :D");
            Socket socket = serverSocket.accept();
            Thread tr = new Thread(new UserThread(socket));
            tr.start();
        }
    }
}
    

