import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Капитан on 22.05.2016.
 */
public class Executable {

    public static final String process = "notepad.exe";
    public static final String command = " /fo csv /nh";

    public static void main(String[] args) throws Exception {

        Thread current = Thread.currentThread();

        while(true) {
            Checker.isRunning(process, command);
            current.sleep(3000);
        }

    }


}
