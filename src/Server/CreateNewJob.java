/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.io.*;

/**
 *
 * @author yana
 */
public class CreateNewJob {
    public String fileNameSH;
    public String resulSH;
    public  String fileNameXRSL;
    public String resulXRSL;
    public String message;
    
    public FileWriter CreateNewSH (String fileName, String result ){
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
    
    public void CreateNewSHExecute(DataInputStream reader, DataOutputStream writer) throws IOException {

                    fileNameSH = reader.readUTF()+".sh";
                    resulSH = reader.readUTF();
                    FileWriter SHFile = CreateNewSH(fileNameSH, resulSH);
        String userName = Login.user.getUserName();
        FileCreator fileCreator=new FileCreator();
        fileCreator.CreateMoveFile(userName, fileNameSH);
        System.out.println("create file ./Move"+userName+".sh");
        String[] command1 = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
        Runtime.getRuntime().exec(command1);
        Runtime.getRuntime().exec("rm Move"+userName+".sh");
        writer.writeUTF("success\n");
        writer.flush();
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
    
    public void CreateNewXRSLExecute(DataInputStream reader, DataOutputStream writer) throws IOException{

                    fileNameXRSL = reader.readUTF()+".xrsl";
                    resulXRSL = reader.readUTF();
                    CreateNewXRSL(fileNameXRSL, resulXRSL);
                    String userName = Login.user.getUserName();

                    FileCreator fileCreator=new FileCreator();

                    fileCreator.CreateMoveFile(userName, fileNameXRSL);
                    System.out.println("create file ./Move"+userName+".sh");
                    String[] command = { "xterm", "/home/yana/Desktop/GridNode/Move"+userName+".sh" };
                    Runtime.getRuntime().exec(command);
                    Runtime.getRuntime().exec("rm Move"+userName+".sh");
                    writer.writeUTF("success");
    }
    

    
}
