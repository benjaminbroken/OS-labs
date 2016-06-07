import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;


public class Frame extends JFrame {

	private JPanel contentPane, leftPanel, rightPanel;
	private JTextArea leftTxtArea, rightTxtArea;
	
	public void writeToLeftPanel(String s) {
		String text = leftTxtArea.getText();
		if (!text.equals(""))
			text += "\n";
		leftTxtArea.setText(text + s);
	}
	
	public void writeToRightPanel(String s) {
		String text = rightTxtArea.getText();
		if (!text.equals(""))
			text += "\n";
		rightTxtArea.setText(text + s);
	}
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(10, 11, 190, 266);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		leftTxtArea = new JTextArea();
		leftTxtArea.setEditable(false);
		leftTxtArea.setBounds(10, 11, 170, 255);
		leftPanel.add(leftTxtArea);
		
		rightPanel = new JPanel();
		rightPanel.setBounds(263, 11, 183, 266);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		rightTxtArea = new JTextArea();
		rightTxtArea.setEditable(false);
		rightTxtArea.setBounds(10, 11, 163, 255);
		rightPanel.add(rightTxtArea);
		
		// when closing
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.close();
				// second modal view
				Main.showModalWindow();
				dispose();
			}
		});
		btnExit.setBounds(187, 322, 89, 23);
		contentPane.add(btnExit);
		
		setVisible(true);
	}
}
