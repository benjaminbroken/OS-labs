import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

/**
 * Created by Капитан on 22.05.2016.
 */
public class Main {

	static Process ex;
	static Process win;

	private static BufferedReader exInput, winInput;
	private static Frame frame;

	public static void close() {
		try {
			exInput.close();
			ex.destroy();
			winInput.close();
			win.destroy();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void showModalWindow() {
		String execStatus;
		try {
			execStatus = Checker.isRunning(Executable.process,
					Executable.command);
			String windowStatus = Checker.isRunning(Windowed.process,
					Windowed.command);
			JOptionPane.showMessageDialog(frame, execStatus + "\n"
					+ windowStatus, "Modal window 1",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void main(String[] args) {

		try {

			// create a frame
			frame = new Frame();

			// first modal window
			showModalWindow();

			ProcessBuilder executable = new ProcessBuilder("java", "-cp",
					"bin", "Executable");
			ex = executable.start();
			exInput = new BufferedReader(new InputStreamReader(
					ex.getInputStream()));

			ProcessBuilder windowed = new ProcessBuilder("java", "-cp", "bin",
					"Windowed");
			win = executable.start();
			winInput = new BufferedReader(new InputStreamReader(
					win.getInputStream()));

			String s = null;
			String s2 = null;
			while (true) {
				// вывод в Memo!
				s = exInput.readLine();
				s2 = winInput.readLine();
				if (s != null) {
					System.out.println(s);
					frame.writeToLeftPanel(s);
				}
				if (s2 != null) {
					System.out.println(s2);
					frame.writeToRightPanel(s2);
				}
				if (s == null && s2 == null)
					break;
			}


		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
