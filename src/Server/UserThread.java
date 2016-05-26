/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;
import services.SaveFile;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Server.CreateNewJob.*;
import static Server.JobActions.*;
import static Server.SubmitJob.*;

/**
 *
 * @author yana
 */
public class UserThread  implements Runnable{
    public  BufferedReader reader;
    public  PrintWriter writer;
    public  Socket socket;

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
                    case "login": Login login = new Login(); login.LoginExecute(reader, writer); break;
                    case "register": Registration registration = new Registration(); registration.RegistrationExecute(reader, writer); break;
                    case "saveFile": SaveFile saveFile = new SaveFile(); saveFile.saveFile(socket, writer);  break;
                    case "createSHFile": CreateNewJob createNewJob = new CreateNewJob(); createNewJob.CreateNewSHExecute(reader, writer); break;
                    case "createXRSLFile": CreateNewJob createNewJob1 = new CreateNewJob(); createNewJob1.CreateNewXRSLExecute(reader, writer); break;
                    case "listOfJobs": SubmitJob submitJob = new SubmitJob(); submitJob.listOfFiles(socket); break;
                    case "submitJob": SubmitJob submitJob1 = new SubmitJob(); submitJob1.submitJob(reader, writer);break;
                    case "findXRSLFile": SubmitJob submitJob2 = new SubmitJob(); submitJob2.findXRSLFile(reader, writer); break;
                    case "ResultOfJob": JobActions jobActions = new JobActions(); jobActions.resultOfJob(socket, reader, writer); break;
                    case "KillJob": JobActions jobActions1 = new JobActions(); jobActions1.killJob(reader, writer);break;
                    case "StatusOfJob": JobActions jobActions2 = new JobActions(); jobActions2.statusOfJob(reader, writer);break;
                    case "ListOfJobs": JobActions jobActions3 = new JobActions(); jobActions3.listOfJobs(writer);  break;
                    case "TestJob":  JobActions jobActions4 = new JobActions(); jobActions4.testJob(reader, writer); break;
                    case "loginWithOutVO":  Login loginVO = new Login(); loginVO.LoginExecuteWithoutVO(reader, writer);  break;
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






