package Server;


import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by yana on 6/21/15.
 */
public class Result {

    public void Result(String message, DataOutputStream writer) throws IOException {
        writer.writeUTF(message);
        writer.flush();
    }
}
