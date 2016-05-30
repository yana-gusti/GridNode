/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.net.InetAddress;
import java.net.Socket;


import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author yana
 */
public class ServerMain implements Runnable{
    public final static int PORT = 7009 ;
    public static String HOSTNAME ;
    public enum Action {CONNECT, LOGIN, LOGINWITHVO, REGISTER, UPLOADFILE, DOWNLOADFILE, SHFILE, XRSLFILE, ALLFILES, SUBMITJOB,
        FINDXRSLFILE, JOBRESULT, ALLJOBS, TESTJOB, JOBDETAILS, KILLJOB, DISCONNECT}
    ServerSocket serverSocket;

    public ServerMain()
    {

        System.out.println("Start Server...");
        try
        {
            HOSTNAME = String.valueOf(InetAddress.getLocalHost());
            serverSocket = new ServerSocket(PORT) ;
            new Thread(this).start();
            //javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() {   createAndShowGUI();}    }   );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        new ServerMain();
//    }
    @Override
    public void run()
    {
        System.out.println("server runs");

        while(true)
        {
            try {

                Socket socket = serverSocket.accept();
                UserThread thread= new UserThread(socket);
                thread.start();

            }
            catch (IOException e)
            {
                System.out.println("Error with  socket");
                e.printStackTrace();
            }
        }

    }
}
    

