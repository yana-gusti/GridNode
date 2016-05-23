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
    public static String jobName;

    public static void resultOfJob() throws IOException {
        jobName = reader.readLine();
        actionExecute("arccat "+jobName+"");
    }
    public static void killJob() throws IOException {
        jobName = reader.readLine();
        actionExecute("arckill "+jobName+"");
    }
    public static void statusOfJob() throws IOException {
        jobName = reader.readLine();
        actionExecute("arcstat "+jobName+" && arccat "+jobName+"");
    }
    public static void listOfJobs() throws IOException {
        jobName = reader.readLine();
        actionExecute("arcstat -a");
    }

    public static void actionExecute(String command)
    {
        String result;
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            // read the output from the command
            while ((result = stdInput.readLine()) != null) {
                writer.write(result);

            }
            writer.flush();
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((result = stdError.readLine()) != null) {
                writer.write(result);
            }
            writer.flush();
        }
        catch (IOException e) {
            writer.write("exception happened - here's what I know: ");
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            writer.flush();
        }

    }


}
