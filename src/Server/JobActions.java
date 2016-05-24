package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Server.UserThread.reader;
import static Server.UserThread.writer;

/**
 * Created by yana on 1/22/15.
 */
public class JobActions {


    public static void resultOfJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arccat "+jobName+"");
        writer.write(result);
        writer.flush();

    }
    public static void killJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arckill "+jobName+"");
        writer.write(result);
        writer.flush();
    }
    public static void statusOfJob() throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcstat "+jobName+" && arccat "+jobName+"");
        writer.write(result);
        writer.flush();

    }
    public static void listOfJobs() throws IOException {
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcstat -a");
        System.out.println(result);
        writer.write(result);
        writer.flush();
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    }


