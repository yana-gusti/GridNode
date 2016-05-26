package Server;

import services.SelectFile;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;


/**
 * Created by yana on 1/22/15.
 */
public class JobActions {




    public void resultOfJob(Socket socket,BufferedReader reader, PrintWriter writer) throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcget "+jobName+"");
        if (result.contains("Results stored at: ")){
            writer.write("save file\n");
            writer.flush();
            String folderName = result.substring(result.lastIndexOf("Results stored at: ") + 1);
            System.out.print(folderName);

            Runtime.getRuntime().exec("zip -r "+folderName+"{.zip,}");
            File file = new File("/home/yana/"+folderName+".zip");
            System.out.println("Send command");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(file.getName());
            int BUFFER_SIZE = 10000;
            FileInputStream fis = new FileInputStream(file);
            byte [] buffer = new byte[BUFFER_SIZE];
            Integer bytesRead = 0;
            while ((bytesRead = fis.read(buffer)) > 0) {
                oos.writeObject(bytesRead);
                oos.writeObject(Arrays.copyOf(buffer, buffer.length));
            }
        }else{
            System.out.print("there are no results");
        }
        writer.write(result+"\n");
        writer.flush();
        writer.close();


    }
    public void killJob(BufferedReader reader, PrintWriter writer) throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arckill "+jobName+"");
        writer.write(result+"\n");
        writer.flush();
        writer.close();

    }
        public void testJob(BufferedReader reader, PrintWriter writer) throws IOException {

        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arctest -J 1 -c arc-ce.grid.upjs.sk");
        writer.write(result+"\n");
        writer.flush();
            writer.close();

        }
    public void statusOfJob(BufferedReader reader, PrintWriter writer) throws IOException {
        String jobName;
        jobName = reader.readLine();
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arccat "+jobName+"");
        writer.write(result+"\n");
        writer.flush();
        writer.close();

    }
    public void listOfJobs(PrintWriter writer) throws IOException {
        JobActions jobActions = new JobActions();
        String result = jobActions.actionExecute("arcstat -a");
        writer.write(result+"\n");
        writer.flush();
        writer.close();
    }

    public String actionExecute(String command) {

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


