/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;


import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author yana
 */
public class SaveFile {
    public static final int BUFFER_SIZE = 100;  
  public static void saveFile(Socket socket) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
        FileOutputStream fos = null;  
        byte [] buffer = new byte[BUFFER_SIZE];  
  
        // 1. Read file name.  
        Object o = ois.readObject();
  
        if (o instanceof String) {  
            fos = new FileOutputStream(o.toString());
            System.out.println(fos);

        } else {  
            throwException("Something is wrong");  
        }  
  
        // 2. Read file to the end.  
        Integer bytesRead = 0;  
  
        do {  
            o = ois.readObject();  
  
            if (!(o instanceof Integer)) {  
                throwException("Something is wrong");  
            }  
  
            bytesRead = (Integer)o;  
  
            o = ois.readObject();  
  
            if (!(o instanceof byte[])) {  
                throwException("Something is wrong");  
            }  
  
            buffer = (byte[])o;  
  
            // 3. Write data to output file.  
            fos.write(buffer, 0, bytesRead);

            
        } while (bytesRead == BUFFER_SIZE);  
        
        String message="File transfer success";
          
        System.out.println(message);  
          
        ArrayList<String> my = new ArrayList<String>();
                
                
                my.add(0, message);
                ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(my);
//      FileCreator fileCreator=new FileCreator();
//      fileCreator.CreateMoveFile(userName, );
//      System.out.println("create file ./Register"+email+".sh");
//      String[] command = { "xterm", "/home/yana/Desktop/GridNode/Register"+email+".sh" };
//      Runtime.getRuntime().exec(command);
//      Thread.sleep(5000);
//      Runtime.getRuntime().exec("rm Register"+email+".sh");
//      Runtime.getRuntime().exec("rm "+userCertName+"");
    }  
  
    public static void throwException(String message) throws Exception {  
        throw new Exception(message);  
    }    
}