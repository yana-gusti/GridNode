/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Server.CreateNewJob.*;
import static Server.JobActions.*;
import static Server.Login.*;
import static Server.Registration.RegistrationExecute;
import static services.SaveFile.saveFile;
import static Server.SubmitJob.*;

/**
 *
 * @author yana
 */
public class UserThread  implements Runnable{
    public static BufferedReader reader;
    public static PrintWriter writer;
    public static Socket socket;

    public UserThread(Socket mSocket) throws IOException{
        this.socket = mSocket;
        writer = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }


    @Override
    public void run() {

        while(true){
            try {

                String function = reader.readLine();
                System.out.println("Funcion is "+function);
                switch(function){
                    case "login": LoginExecute(); break;
                    case "register": RegistrationExecute(); break;
                    case "saveFile": saveFile();  break;
                    case "createSHFile": CreateNewSHExecute(); break;
                    case "createXRSLFile": CreateNewXRSLExecute(); break;
                    case "listOfJobs": listOfFiles(); break;
                    case "submitJob": submitJob();break;
                    case "findXRSLFile": findXRSLFile(); break;
                    case "ResultOfJob": JobActions.resultOfJob(); break;
                    case "KillJob": killJob();break;
                    case "StatusOfJob": statusOfJob();break;
                    case "ListOfJobs": listOfJobs();  break;
                    case "TestJob":   testJob(); break;
                    case "loginWithOutVO":  LoginExecuteWithoutVO();  break;
                    //          case "payments_perName": payments_byName(); break;

                    // Za drugite funkcii si dobavq6 case-ove + metodi dolu
                    // za da vleze v metod clienta purvo puska writer.write("imeto na case-a\n")
                    // posle write-va abs su6tite ne6ta koito readva v metoda
                    // v slu4aq v metoda ako ima String name = reader.readLine(); i primerno
                    // String asd = reader.readLine();
                    // togava v clienta tr da ima writer.write("ime\n");
                    // sled tva writer.write("asd\n");


                    default : break;
                }

            }
            catch (IOException ex) {
                Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}






