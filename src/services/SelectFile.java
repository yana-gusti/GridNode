/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author yana
 */
public class SelectFile extends JFileChooser{
    public static final int BUFFER_SIZE = 100; 

   

    public static void SelectFile(File file,  JLabel errorlabel) throws IOException, ClassNotFoundException {
         Socket socket = null;
        
            socket = new Socket("localhost", 9999);
        
        
            
                String command = "saveFile";
                PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);
                    toClient.println(command);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());  
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  
  
        oos.writeObject(file.getName());  
  
        FileInputStream fis = new FileInputStream(file);  
        byte [] buffer = new byte[BUFFER_SIZE];  
        Integer bytesRead = 0;  
  
        while ((bytesRead = fis.read(buffer)) > 0) {  
            oos.writeObject(bytesRead);  
            oos.writeObject(Arrays.copyOf(buffer, buffer.length));  
        }  
                
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                    
                   ArrayList<String> result = new ArrayList<String>();
            
                    ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());

                
                    Object object = objectInput.readObject();
                    result = (ArrayList<String>) object;
                    String result1 = result.get(0);
                    errorlabel.setText(result1);
       
        } 
    
    
   
    
   
    

}
