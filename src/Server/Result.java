package Server;


import java.io.PrintWriter;

/**
 * Created by yana on 6/21/15.
 */
public class Result {

    public void Result(String message, PrintWriter writer){
        writer.write(message);
        writer.flush();
    }
}
