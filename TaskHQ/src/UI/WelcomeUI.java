package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class WelcomeUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeUI window = new WelcomeUI();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 725, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTask = new JLabel("Task");
		lblTask.setFont(new Font("Comfortaa", Font.BOLD, 70));
		lblTask.setForeground(hex2Rgb("#011A27"));
		lblTask.setBounds(187, 83, 328, 161);
		frame.getContentPane().add(lblTask);
		
		JLabel lblHq = new JLabel("HQ");
		lblHq.setForeground(hex2Rgb("#F0810F"));
		lblHq.setFont(new Font("Comfortaa", Font.BOLD, 70));
		lblHq.setBounds(356, 83, 328, 161);
		frame.getContentPane().add(lblHq);
		
		JLabel lblSlogan = new JLabel("Quick Tasks, Quick Cash!");
		lblSlogan.setForeground(hex2Rgb("#F0810F"));
		lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlogan.setFont(new Font("Comfortaa", Font.BOLD, 20));
		lblSlogan.setBounds(130, 197, 417, 47);
		frame.getContentPane().add(lblSlogan);
		
		JPanel pLine = new JPanel();
		pLine.setBackground(hex2Rgb("#F0810F"));
		pLine.setBounds(130, 248, 424, 3);
		frame.getContentPane().add(pLine);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setForeground(new Color(1, 26, 39));
		btnCreateAccount.setFont(new Font("Comfortaa", Font.BOLD, 15));
		btnCreateAccount.setForeground(hex2Rgb("#011A27"));
		btnCreateAccount.setBackground(new Color(240, 129, 15));
		btnCreateAccount.setBounds(215, 349, 271, 35);
		frame.getContentPane().add(btnCreateAccount);
		
		btnCreateAccount.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CreateAccountUI c = new CreateAccountUI();
				c.main(null);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Comfortaa", Font.BOLD, 15));
		btnLogin.setBackground(hex2Rgb("#063852"));
		btnLogin.setBounds(215, 303, 271, 35);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LoginUI log = new LoginUI();
				log.main(null);
			}
		});
	}
	
	/**
	 * @author "xhh" from https://stackoverflow.com/questions/4129666/how-to-convert-hex-to-rgb-using-java
	 * @param colorStr e.g. "#FFFFFF"
	 * @return Color
	 */
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}