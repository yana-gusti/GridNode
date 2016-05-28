package Server;

import services.ActionExecute;

import java.io.*;
import java.net.Socket;


/**
 * Created by yana on 1/22/15.
 */
public class JobActions implements Serializable {

    public void killJob(DataInputStream reader, Socket socket) throws IOException {
        String jobName;
        jobName = reader.readUTF();
        new ActionExecute("arckill "+jobName+"", socket);

    }
    public void testJob(Socket socket) throws IOException {

        new ActionExecute("arctest -J 1 -c arc-ce.grid.upjs.sk", socket);
        }
    public void statusOfJob(DataInputStream reader,  Socket socket) throws IOException {
        String jobName;
        jobName = reader.readUTF();
        System.out.print("get "+jobName);
        new ActionExecute("arccat "+jobName+"", socket);
    }
    public void listOfJobs(Socket socket) throws IOException {
         new ActionExecute("arcstat -a", socket);
    }



    }


