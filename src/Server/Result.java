package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by yana on 6/21/15.
 */
public class Result {

    public static void Result(String message, Socket s){
        ArrayList<String> my = new ArrayList<String>();


                my.add(0, message);
        ObjectOutputStream objectOutput = null;
        try {
            objectOutput = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutput.writeObject(my);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
