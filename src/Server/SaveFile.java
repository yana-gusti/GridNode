/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static Server.UserThread.socket;
import static Server.UserThread.writer;

/**
 *
 * @author yana
 */
public class SaveFile {
    public static final int BUFFER_SIZE = 100;
    static String message;
  public static void saveFile() throws IOException {

      System.out.print("start");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
        FileOutputStream fos = null;  
        byte [] buffer ;
  
        // 1. Read file name.  
      Object o = null;
      try {
          o = ois.readObject();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }

      if (o instanceof String) {
            fos = new FileOutputStream(o.toString());
            System.out.println(fos);

        } else {  
            message = "Something is wrong\n";
        }  
  
        // 2. Read file to the end.  
        Integer bytesRead = 0;  
  
        do {
            try {
                o = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (!(o instanceof Integer)) {  
                message = "Something is wrong\n";
            }  
  
            bytesRead = (Integer)o;

            try {
                o = ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (!(o instanceof byte[])) {  
                message = "Something is wrong\n";
            }  
  
            buffer = (byte[])o;  
  
            // 3. Write data to output file.  
            fos.write(buffer, 0, bytesRead);

            
        } while (bytesRead == BUFFER_SIZE);  
        
        message="File transfer success\n";
          
        System.out.println(message);
          
        writer.write(message);
        writer.flush();
    }  
  


}
