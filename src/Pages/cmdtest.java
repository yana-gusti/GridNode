/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author yana
 */
public class cmdtest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process ls=null;
        BufferedReader input=null;
        String line=null;
        
            try {

                   ls= Runtime.getRuntime().exec(new String[]{"ls","-l"});
                   input = new BufferedReader(new InputStreamReader(ls.getInputStream()));
                   Thread.sleep(2000);

                } catch (IOException e1) {
                    e1.printStackTrace();  
                    
                }
                
               
               try {
                       while( (line=input.readLine())!=null)
                        System.out.println(line);
                       
                } catch (IOException e1) {
                    e1.printStackTrace();  
                    
                }        
    
    }
}
