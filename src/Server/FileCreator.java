package Server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by grid on 08.05.15.
 */
public class FileCreator {
    String proxyfilename = null;
    String loginfilename = null;
    public void CreateProxyFile(String vo){


        try {
            File file = new File("proxyInit.sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("voms-proxy-init -voms " + vo + " -valid 48:00 -pwstdin");
            output.close();
            Runtime.getRuntime().exec("chmod +x proxyInit.sh");
            proxyfilename = file.getName();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void CreateLoginFile(String pass){
        try {
            File file1 = new File("Login.sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file1));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("cd /home/grid/IdeaProjects/GridNode");
            output.newLine();
            output.append("./proxyInit.sh<<< \"" + pass + "\"");
            output.newLine();
            output.append("sleep 2");
            Runtime.getRuntime().exec("chmod +x Login.sh");
            System.out.println("Files were created");

            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }


    }

        public static void main (String arg[]) throws IOException {



        }


}
