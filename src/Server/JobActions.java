package Server;

import services.SelectFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static Server.UserThread.reader;
import static Server.UserThread.socket;
import static Server.UserThread.writer;

/**
 * Created by yana on 1/22/15.
 */
public class JobActions {




    public static void resultOfJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcget "+jobName+"");
        writer.write(result);
        writer.flush();
        String folderName = result.substring(result.lastIndexOf("Results stored at: ") + 1);
//        writer.close();
        System.out.print(folderName);

        Runtime.getRuntime().exec("zip -r "+folderName+"{.zip,}");
        File file = new File("/home/yana/"+folderName+".zip");
        try {
            String fromClient = SelectFile.SelectFile(socket, writer, reader, file);
            System.out.print(fromClient);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void killJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arckill "+jobName+"");
        writer.write(result);
        writer.flush();
        writer.close();
    }
        public static void testJob() throws IOException {

        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arctest -J 1 -c arc-ce.grid.upjs.sk");
        writer.write(result);
        writer.flush();
            writer.close();
    }
    public static void statusOfJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arccat "+jobName+"");
        writer.write(result);
        writer.flush();
        writer.close();

    }
    public static void listOfJobs() throws IOException {
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcstat -a");
        writer.write(result);
        writer.flush();
        writer.close();
    }

    private String actionExecute(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
            reader.close();
            System.out.println("finish record");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    }


