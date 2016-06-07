import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Created by Капитан on 22.05.2016.
 */
public class Checker {

	public static String isRunning(String name, String command)
			throws IOException {
		String line;
		String pidInfo = "";

		Process p = Runtime.getRuntime().exec(
				System.getenv("windir") + "\\system32\\" + "tasklist.exe"
						+ command);

		BufferedReader input = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		while ((line = input.readLine()) != null) {
			pidInfo += line;
		}

		input.close();

		if (pidInfo.contains(name)) {
			System.out.println(name + " is running");
			return name + " is running";
		} else {
			System.out.println(name + " is not running");
			return name + " is not running";
		}
	}
}
