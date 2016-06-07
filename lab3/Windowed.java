/**
 * Created by Капитан on 22.05.2016.
 */
public class Windowed {

    public static final String process = "UltraISO";
    public static final String command = " /V /FI \"WindowTitle eq UltraISO\"";

    public static void main(String[] args) throws Exception {

        Thread current = Thread.currentThread();

        while(true) {
            Checker.isRunning(process, command);
            current.sleep(3000);
        }

    }

}
