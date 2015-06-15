/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public static void CreateNewSHExecute() throws IOException, ClassNotFoundException{
        ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    fileNameSH = titleList.get(0);
                    resulSH = titleList.get(1);
                    System.out.println(fileNameSH+"   "+resulSH);
                    FileWriter SHFile = CreateNewSH(fileNameSH, resulSH);
                    
                     System.out.println("fedfdsfsdf");
               
                ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
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
    
    public static void CreateNewXRSLExecute() throws IOException, ClassNotFoundException{
        ArrayList<String> titleList = new ArrayList<String>();
            
                ObjectInputStream objectInput = new ObjectInputStream(ServerMain.skt.getInputStream());

                
                    Object object = objectInput.readObject();
                    titleList = (ArrayList<String>) object;
                    fileNameXRSL = titleList.get(0);
                    resulXRSL = titleList.get(1);
                    System.out.println(fileNameXRSL+"   "+resulXRSL);
                    FileWriter SHFile = CreateNewSH(fileNameXRSL, resulXRSL);
                    
                     System.out.println("fedfdsfsdf");
               
                ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(ServerMain.skt.getOutputStream());
                objectOutput.writeObject(my);
    }
    

    
}
