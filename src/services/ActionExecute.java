package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by yana on 5/28/16.
 */
public class ActionExecute implements Serializable {

    public ArrayList<String> list;

    public StringBuffer output;

    public ActionExecute(String command, Socket socket) {
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            list = new ArrayList<>();
            output = new StringBuffer();
            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
                list.add(line + "\n");
            }
//            reader.close();

            System.out.println(list);
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(list);
            System.out.println("finish record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
