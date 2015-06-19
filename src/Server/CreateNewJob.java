/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
          outFile = new FileWriter(fileName +".sh",true);
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
    
    public static void CreateNewSHExecute(Socket s) throws IOException, ClassNotFoundException, InterruptedException {
        ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    fileNameSH = titleList.get(0);
                    resulSH = titleList.get(1);
                    System.out.println(fileNameSH+"   "+resulSH);
                    FileWriter SHFile = CreateNewSH(fileNameSH, resulSH);
        String userName = Login.user.getUserName();
        FileCreator fileCreator=new FileCreator();
        fileCreator.CreateMoveFile(userName, fileNameSH);
        System.out.println("create file ./Move"+userName+".sh");
        String[] command1 = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
        Runtime.getRuntime().exec(command1);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("rm Move"+userName+".sh");
                    
                     System.out.println("fedfdsfsdf");
               
                ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(my);
    }
     public static FileWriter CreateNewXRSL (String fileName, String result ){
        FileWriter outFile = null;
        try {
//            
          outFile = new FileWriter(fileName +".xrsl",true);
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
    
    public static void CreateNewXRSLExecute(Socket s) throws IOException, ClassNotFoundException, InterruptedException {
        ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    fileNameXRSL = titleList.get(0);
                    resulXRSL = titleList.get(1);
                    System.out.println(fileNameXRSL+"   "+resulXRSL);
                    FileWriter SHFile = CreateNewXRSL(fileNameXRSL, resulXRSL);
                    String userName = Login.user.getUserName();

        FileCreator fileCreator=new FileCreator();

                    fileCreator.CreateMoveFile(userName, fileNameXRSL);
                    System.out.println("create file ./Move"+userName+".sh");
                    String[] command = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
                    Runtime.getRuntime().exec(command);
                    Runtime.getRuntime().exec("rm Move"+userName+".sh");
                    Thread.sleep(5000);

                    
                     System.out.println("fedfdsfsdf");
               
                ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
                objectOutput.writeObject(my);
    }
    

    
}
