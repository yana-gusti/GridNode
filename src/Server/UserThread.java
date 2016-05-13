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

import static Server.CreateNewJob.CreateNewSHExecute;
import static Server.CreateNewJob.CreateNewXRSLExecute;
import static Server.Login.Login;
import static Server.Login.LoginExecute;
import static Server.Registration.RegistrationExecute;
import static Server.SaveFile.saveFile;

/**
 *
 * @author yana
 */
public class UserThread implements Runnable{
    Socket s=null;
    public BufferedReader reader;
    public PrintWriter writer;

    public UserThread(Socket socket) throws IOException {
        this.s=socket;
        writer = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                String function = reader.readLine();
                System.out.println("Funcion is " + function);
                switch (function) {
                    case "login":
                        LoginExecute(reader, writer);
                        break;
                    case "register":
                        RegistrationExecute(reader, writer);
                        break;
                    case "createSHFile":
                        CreateNewSHExecute(reader, writer);
                        break;
                    case "createXRSLFile":
                        CreateNewXRSLExecute(reader, writer);
                        break;
                    case "saveFile":
                        saveFile(s, reader, writer);
                        break;
//                        case "findXRSLFile":
//                            SubmitJob.FindXRSLFile(s);
//                            break;
//                        case "submitJob":
//                            SubmitJob.SubmitJob(s);
//                            break;
//                        case "listOfJobs":
//                            SubmitJob.listOfFiles(Login.user.getUserName(), s);
//                            break;
//                        case "getResultLogin":
//                            System.out.println(Login.message);
//                            Result.Result(Login.message, s);
//                            break;
//                        case "getResult":
//                            Result.Result(CreateNewJob.message, s);
//                            break;
//                        case "getResultJobList":
//                            Result.Result(SubmitJob.message, s);
//                            break;

                }
            } catch (Exception ex) {
                Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public void run() {
//    try{
//        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
//
//    }catch(IOException e){
//        System.out.println("IO error in server thread");
//    }
//
//    try {
//        action=is.readLine();
//        while(action.compareTo("QUIT")!=0){
//
//            if (action.equals("login")) {
//                result =LoginExecute(s);
//                System.out.println(result);
//
//             } else if (action.equals("registr")) {
//                 RegistrationExecute(s);
//
//             }else if (action.equals("createSHFile")) {
//                result =CreateNewSHExecute(s);
//
//
//             }else if (action.equals("createXRSLFile")) {
//                 result =CreateNewXRSLExecute(s);
//
//             }
//             else if (action.equals("saveFile")) {
//               saveFile(s);
//
//             } else if (action.equals("findXRSLFile")) {
//               SubmitJob.FindXRSLFile(s);
//
//             }else if (action.equals("submitJob")) {
//               SubmitJob.SubmitJob(s);
//
//             }else if (action.equals("listOfJobs")) {
//                SubmitJob.listOfFiles(Login.user.getUserName(), s);
//
//            }
//            else if (action.equals("getResultLogin")) {
//                System.out.println(Login.message);
//                Result.Result(Login.message, s);
//
//            }
//            else if (action.equals("getResult")) {
//                System.out.println(CreateNewJob.message);
//                Result.Result(CreateNewJob.message, s);
//
//            }
//            else if (action.equals("getResultRegistr")) {
//                System.out.println(Registration.message);
//                Result.Result(Registration.message, s);
//
//            }
//            else if (action.equals("getResultJobList")) {
//                System.out.println(SubmitJob.message);
//                Result.Result(SubmitJob.message, s);
//
//            }
//
//
//
//             System.out.println("connection reset2");
//            s.setKeepAlive(true);
//            System.out.println("connection reset 4");
//            action=is.readLine();
//             System.out.println("connection reset 5");
//            s.setKeepAlive(true);
//             System.out.println("connection reset3");
//
//        }
//    } catch (IOException e) {
//
//        action=this.getName(); //reused String line for getting thread name
//        System.out.println("IO Error/ Client "+action+" terminated abruptly");
//    }
//    catch(NullPointerException e){
//        action=this.getName(); //reused String line for getting thread name
//        System.out.println("Client "+action+" Closed");
//    }   catch (ClassNotFoundException ex) {
//            Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(UserThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    finally{
//    try{
//        System.out.println("Connection Closing..");
//        if (is!=null){
//            is.close();
//            System.out.println(" Socket Input Stream Closed");
//        }
//
//
//        if (s!=null){
//        s.close();
//        System.out.println("Socket Closed");
//        }
//
//        }
//    catch(IOException ie){
//        System.out.println("Socket Close Error");
//    }
//    }//end finally
//    }
    
}
