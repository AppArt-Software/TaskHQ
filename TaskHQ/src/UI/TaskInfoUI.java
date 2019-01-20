package UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class TaskInfoUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskInfoUI window = new TaskInfoUI("Test","Test","Test","Test","Test","Test");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TaskInfoUI(String employer, String location, String start, String end, String skills, String description) {
		initialize(employer, location, start, end, skills, description);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String employer, String location, String start, String end, String skills, String description) {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 360);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		System.out.println("HERE");
		
		JPanel mainpanel= new JPanel();
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
		mainpanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel panel1= new JPanel();
		panel1.setBackground(Color.WHITE);
		JPanel panel2= new JPanel();
		panel2.setBackground(Color.WHITE);
		JPanel panel3= new JPanel();
		panel3.setBackground(Color.WHITE);
		
		JLabel label1= new JLabel("Employer: ");
		label1.setFont(new Font("Comfortaa", Font.BOLD, 20));
		JLabel label2= new JLabel(employer);
		label2.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		JLabel label3= new JLabel("Location: ");
		label3.setFont(new Font("Comfortaa", Font.BOLD, 20));
		JLabel label4= new JLabel(location);
		label4.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		JLabel label5= new JLabel("Time:");
		label5.setFont(new Font("Comfortaa", Font.BOLD, 20));
		JLabel label6= new JLabel("Start: "+start+" End: "+end);
		label6.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		JLabel label7= new JLabel("Required Skills:");
		label7.setFont(new Font("Comfortaa", Font.BOLD, 20));
		JLabel label8= new JLabel(skills);
		label8.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		JLabel label9= new JLabel("Description:");
		label9.setFont(new Font("Comfortaa", Font.BOLD, 20));
		JLabel label10= new JLabel(description);
		label10.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		
		
		panel1.add(label1);
		panel1.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		
		
		JPanel longpanel= new JPanel();
		longpanel.setBackground(Color.WHITE);
		longpanel.setLayout(new BoxLayout(longpanel, BoxLayout.Y_AXIS));
		
		longpanel.add(Box.createRigidArea(new Dimension(0,10)));
		longpanel.add(label7);
		longpanel.add(label8);
		longpanel.add(Box.createRigidArea(new Dimension(0,10)));
		longpanel.add(label9);
		longpanel.add(label10);
		
		label7.setAlignmentX(Component.CENTER_ALIGNMENT);
		label8.setAlignmentX(Component.CENTER_ALIGNMENT);
		label9.setAlignmentX(Component.CENTER_ALIGNMENT);
		label10.setAlignmentX(Component.CENTER_ALIGNMENT);

		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		mainpanel.add(longpanel);

		frame.getContentPane().add(mainpanel);
		
		frame.setVisible(true);
	}

}
