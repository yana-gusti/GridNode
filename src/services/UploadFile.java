/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static grid_node.Main.address;
import static grid_node.Main.port;

/**
 *
 * @author yana
 */
public class UploadFile extends JFileChooser{
    public int BUFFER_SIZE = 10000;


   

    public  String UploadFile(Socket s, DataInputStream reader, File file) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

        oos.writeObject(file.getName());
  
        FileInputStream fis = new FileInputStream(file);  
        byte [] buffer = new byte[BUFFER_SIZE];  
        Integer bytesRead = 0;  
  
        while ((bytesRead = fis.read(buffer)) > 0) {  
            oos.writeObject(bytesRead);  
            oos.writeObject(Arrays.copyOf(buffer, buffer.length));  
        }  
          return reader.readUTF();
       
        } 
    
    
   
    
   
    

}
