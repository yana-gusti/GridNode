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
    public void CreateVomsProxyFile(String vo, String name){


        try {
            File file = new File("proxyInit.sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'arcproxy -S "+vo+" -p key=file:/home/yana/Desktop/GridNode/pass.txt'");
//            output.append("sudo -H -u "+name+" bash -c 'arcproxy'");
            output.close();
            Runtime.getRuntime().exec("chmod +x proxyInit.sh");
            proxyfilename = file.getName();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
        public void CreateProxyFile(String name){


        try {
            File file = new File("proxyInit.sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("sudo -H -u yana bash -c 'cd /home/"+name+"/.globus' -p $(echo 1 | openssl passwd -1 -stdin)");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'arcproxy -p key=file:/home/yana/Desktop/GridNode/pass.txt'");
            output.close();
            Runtime.getRuntime().exec("chmod +x proxyInit.sh");
            proxyfilename = file.getName();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public void CreatePassFile(String pass){
        try {
            File file1 = new File("pass.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file1));
            output.append(pass);
            output.newLine();
            output.close();
            Runtime.getRuntime().exec("chmod +x pass.txt");
            System.out.println("Files were created");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    public void CreateRegistrationFile( String name, 
            String userCernName, String userKeyName){
        try {
            File file1 = new File("Register"+name+".sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file1));

            output.append("#! /bin/bash"); 
            output.newLine();

            output.append("sudo -S useradd -m -s /bin/bash -p $"
                    + "(echo 1 | openssl passwd -1 -stdin) "+name+"");
            output.newLine();
            output.append("sudo usermod -aG sudo,adm "+name+"");
            output.newLine();
            output.append("sudo -H -u yana bash -c 'chmod +xrw /home/yana/Desktop/GridNode/userkey.pem'");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'mkdir /home/"+name+"/.globus'");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'cp "
                    + "/home/yana/Desktop/GridNode/"+userCernName+" /home/"+name+"/.globus'");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'cp "
                    + "/home/yana/Desktop/GridNode/"+userKeyName+" /home/"+name+"/.globus'");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'chmod 400 "
                    + "/home/"+name+"/.globus/"+userKeyName+"'");
            output.newLine();
            output.append("sudo -H -u "+name+" bash -c 'chmod 644 "
                    + "/home/"+name+"/.globus/"+userCernName+"'");
            output.newLine();
            output.append("sleep 2");
            output.close();
            Runtime.getRuntime().exec("chmod +x Register"+name+".sh");
            System.out.println("Files were created");


        } catch ( IOException e ) {
            e.printStackTrace();
        }


    }

    public void CreateMoveFile( String userName,String fileName){
        try {
            File file1 = new File("Move"+userName+".sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file1));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("chmod +xrw /home/yana/Desktop/GridNode/"+fileName+"");


            output.newLine();
            output.append("echo 1 | sudo -H -u "+userName+" bash -c 'cp "
                    + "/home/yana/Desktop/GridNode/"+fileName+" /home/"+userName+"'");
            output.newLine();
            output.append("sleep 2");
            Runtime.getRuntime().exec("chmod +x Move"+userName+".sh");
            System.out.println("Files were moved");

            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

        public static void SubmitJobFile(String userName, String cluster, String fileNameXRSL) throws IOException {
            File file1 = new File("SubmitJobFile"+userName+".sh");
            BufferedWriter output = new BufferedWriter(new FileWriter(file1));

            output.append("#! /bin/bash");
            output.newLine();
            output.append("echo 1  | sudo -H -u "+userName+" bash -c 'cd /home/"+userName+"'");
            output.newLine();
            output.append("echo 1  | sudo -H -u "+userName+" bash -c 'arcsub -c "+cluster+" "+fileNameXRSL+"'");
            output.newLine();
            output.append("sleep 2");
            Runtime.getRuntime().exec("chmod +x SubmitJobFile"+userName+".sh");
            System.out.println("SubmitJobFile was created");

            output.close();
        }

        public static void main (String arg[]) throws IOException {



        }


}
