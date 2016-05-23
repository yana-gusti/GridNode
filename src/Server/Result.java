package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static Server.UserThread.writer;

/**
 * Created by yana on 6/21/15.
 */
public class Result {

    public static void Result(String message){
        writer.write(message);
        writer.flush();
    }
}
