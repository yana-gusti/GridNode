/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author yana
 */
public class CreateNewJob {
    public static String fileNameSH;
    public static String resulSH;
    public static String fileNameXRSL;
    public static String resulXRSL;
    public static String message;
    
    public static FileWriter CreateNewSH (String fileName, String result ){
        FileWriter outFile = null;
        try {
//            
          outFile = new FileWriter(fileName, true);
	} catch (IOException e1) {
		e1.printStackTrace();
		}
	try {
            outFile.write(result);
            message ="success";
		} catch (IOException e1) {
		e1.printStackTrace();
				}
	try {
	outFile.close();
        } catch (IOException e1) {
	e1.printStackTrace();
        }
        return outFile;
    }
    
    public static void CreateNewSHExecute(BufferedReader reader, PrintWriter writer) throws IOException {

                    fileNameSH = reader.readLine()+".sh";
                    resulSH = reader.readLine();
                    FileWriter SHFile = CreateNewSH(fileNameSH, resulSH);
        String userName = Login.user.getUserName();
        FileCreator fileCreator=new FileCreator();
        fileCreator.CreateMoveFile(userName, fileNameSH);
        System.out.println("create file ./Move"+userName+".sh");
        String[] command1 = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
        Runtime.getRuntime().exec(command1);
        Runtime.getRuntime().exec("rm Move"+userName+".sh");
        writer.write(message);
    }
     public static FileWriter CreateNewXRSL (String fileName, String result ){
        FileWriter outFile = null;
        try {
//            
          outFile = new FileWriter(fileName ,true);
	} catch (IOException e1) {
		e1.printStackTrace();
		}
	try {
            outFile.write(result);
            message ="success";
		} catch (IOException e1) {
		e1.printStackTrace();
				}
	try {
	outFile.close();
        } catch (IOException e1) {
	e1.printStackTrace();
        }
        return outFile;
    }
    
    public static void CreateNewXRSLExecute(BufferedReader reader, PrintWriter writer) throws IOException{

                    fileNameXRSL = reader.readLine()+".xrsl";
                    resulXRSL = reader.readLine();
                    FileWriter XRSLFile = CreateNewXRSL(fileNameXRSL, resulXRSL);
                    String userName = Login.user.getUserName();

                    FileCreator fileCreator=new FileCreator();

                    fileCreator.CreateMoveFile(userName, fileNameXRSL);
                    System.out.println("create file ./Move"+userName+".sh");
                    String[] command = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
                    Runtime.getRuntime().exec(command);
                    Runtime.getRuntime().exec("rm Move"+userName+".sh");
        writer.write(message);
    }
    

    
}
