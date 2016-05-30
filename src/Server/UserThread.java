/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;
import services.ResultOfJob;
import services.DownloadFile;
import services.UploadFile;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author yana
 */
public class UserThread  extends Thread implements Serializable{
    private DataInputStream reader;
    private DataOutputStream writer;
    private Socket socket;

    public UserThread(Socket mSocket) throws IOException{
        this.socket = mSocket;

    }


    @Override
    public void run() {

        try {
            writer = new DataOutputStream(socket.getOutputStream()) ;
            reader = new DataInputStream(socket.getInputStream()) ;
            ServerMain.Action act;
            do {
                // read Action
                act = ServerMain.Action.valueOf(reader.readUTF()); // read string -> enum
                System.out.println("action :" + act);
                switch (act) {
                    case CONNECT:
                        System.out.println("Connection is established");
                        writer.writeUTF("Connection is established");
                        break;
                    case LOGINWITHVO:
                        new Login().LoginExecute(reader, writer, socket);
                        break;
                    case REGISTER:
                        new Registration().RegistrationExecute(reader, writer, socket);
                        break;
                    case UPLOADFILE:
                        new DownloadFile().DownloadFile(socket, writer);
                        break;
                    case DOWNLOADFILE:
                        new ResultOfJob().downloadResultOfJob(socket, reader);
                        break;
                    case SHFILE:
                        new CreateNewJob().CreateNewSHExecute(reader, writer);
                        break;
                    case XRSLFILE:
                        new CreateNewJob().CreateNewXRSLExecute(reader, writer);
                        break;
                    case ALLFILES:
                        new SubmitJob().listOfFiles(socket);
                        break;
                    case SUBMITJOB:
                        new SubmitJob().submitJob(reader, socket);
                        break;
                    case FINDXRSLFILE:
                        new SubmitJob().findXRSLFile(reader, writer, socket);
                        break;
                    case JOBRESULT:
                        new ResultOfJob().MakeResultOfJob(socket, reader, writer);
                        break;
                    case KILLJOB:
                        new JobActions().killJob(reader, socket);
                        break;
                    case JOBDETAILS:
                        new JobActions().statusOfJob(reader, socket);
                        break;
                    case ALLJOBS:
                        new JobActions().listOfJobs(socket);
                        break;
                    case TESTJOB:
                        new JobActions().testJob(socket);
                        break;
                    case LOGIN:
                        new Login().LoginExecuteWithoutVO(reader, writer, socket);
                        break;
                }
            } while (act != ServerMain.Action.DISCONNECT);
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error with client socket");
            ex.printStackTrace();
        }

    }
    }






