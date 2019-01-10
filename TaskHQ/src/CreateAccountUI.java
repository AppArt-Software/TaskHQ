import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class CreateAccountUI {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassword2;
	private JFormattedTextField txtAge;
	private JPanel pUsername, pFirstName, pLastName, pPassword1, pPassword2;
	private JPanel pAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountUI window = new CreateAccountUI();
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
	public CreateAccountUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 307, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtUsername.setBounds(10, 26, 271, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblTUsername = new JLabel("Email");
		lblTUsername.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblTUsername.setBounds(11, 11, 46, 14);
		frame.getContentPane().add(lblTUsername);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(10, 72, 271, 20);
		frame.getContentPane().add(txtFirstName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblFirstName.setBounds(11, 57, 140, 14);
		frame.getContentPane().add(lblFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 118, 271, 20);
		frame.getContentPane().add(txtLastName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblLastName.setBounds(11, 103, 140, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblPassword.setBounds(11, 149, 140, 14);
		frame.getContentPane().add(lblPassword);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtPassword1.setBounds(10, 164, 271, 20);
		frame.getContentPane().add(txtPassword1);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtPassword2.setBounds(10, 210, 271, 20);
		frame.getContentPane().add(txtPassword2);
		
		JLabel lblRepeatPass = new JLabel("Repeat Password");
		lblRepeatPass.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblRepeatPass.setBounds(11, 195, 140, 14);
		frame.getContentPane().add(lblRepeatPass);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setForeground(hex2Rgb("#011A27"));
		btnCreateAccount.setBackground(hex2Rgb("#F0810F"));
		btnCreateAccount.setFont(new Font("Comfortaa", Font.BOLD, 15));
		btnCreateAccount.setBounds(10, 318, 271, 23);	
		frame.getContentPane().add(btnCreateAccount);
		
		pUsername = new JPanel();
		pUsername.setBackground(hex2Rgb("#011A27"));
		pUsername.setBounds(10, 26, 271, 23);
		frame.getContentPane().add(pUsername);
		
		pFirstName = new JPanel();
		pFirstName.setBackground(hex2Rgb("#011A27"));
		pFirstName.setBounds(10, 72, 271, 23);
		frame.getContentPane().add(pFirstName);
		
		pLastName = new JPanel();
		pLastName.setBackground(hex2Rgb("#011A27"));
		pLastName.setBounds(10, 118, 271, 23);
		frame.getContentPane().add(pLastName);
		
		pPassword1 = new JPanel();
		pPassword1.setBackground(hex2Rgb("#011A27"));
		pPassword1.setBounds(10, 164, 271, 23);
		frame.getContentPane().add(pPassword1);
		
		pPassword2 = new JPanel();
		pPassword2.setBackground(hex2Rgb("#011A27"));
		pPassword2.setBounds(10, 210, 271, 23);
		frame.getContentPane().add(pPassword2);
		
		JLabel lblAge = new JLabel("Age (Years)");
		lblAge.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblAge.setBounds(10, 241, 140, 20);
		frame.getContentPane().add(lblAge);
		
	try {
		MaskFormatter formatter = new MaskFormatter("###");
		txtAge = new JFormattedTextField(formatter);
		txtAge.setBounds(10, 262, 271, 20);
		frame.getContentPane().add(txtAge);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		pAge = new JPanel();
		pAge.setBackground(new Color(1, 26, 39));
		pAge.setBounds(10, 262, 271, 23);
		frame.getContentPane().add(pAge);
		
		btnCreateAccount.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetHighlights();
				
				String username = txtUsername.getText().toString();
				String firstName = txtFirstName.getText().toString();
				String lastName = txtLastName.getText().toString();
				String password1 = new String(txtPassword1.getPassword());
				String password2 = new String (txtPassword2.getPassword());
				String age = txtAge.getText().toString();
				
				if (username.trim().length() != 0 && firstName.trim().length() != 0 &&
						lastName.trim().length() != 0 && password1.length() != 0 &&
						password2.length() !=  0 && age.trim().length() != 0) {
						
					if (username.contains("@")) {
						if (password1.equals(password2)) {
							if (password1.length() > 6) {
								/*
								 * TODO: CREATE ACCOUNT
								 */
							} else {
								clearText(txtPassword1);
								clearText(txtPassword2);
								pPassword1.setBackground(Color.RED);
								pPassword2.setBackground(Color.RED);
								showError("Oops!", "Your password must be at least 6 characters!");
							}				
						} else {
							System.out.println(password1 + " " + password2);
							clearText(txtPassword1);
							clearText(txtPassword2);
							pPassword1.setBackground(Color.RED);
							pPassword2.setBackground(Color.RED);
							showError("Oops!", "Your passwords don't match!");
						}			
					} else {
						clearText(txtUsername);
						pUsername.setBackground(Color.RED);
						showError("Oops!", "You must enter a valid email!");
					}
						
				} else {	
					pUsername.setBackground(Color.RED);
					pFirstName.setBackground(Color.RED);
					pLastName.setBackground(Color.RED);
					pPassword1.setBackground(Color.RED);
					pPassword2.setBackground(Color.RED);
					pAge.setBackground(Color.RED);
					clearBoxes();
					showError("Oops!", "You must fill all boxes!");
					
					
				}
				
			} 
		});
		
		
	}
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Properly clears a textField
	 * @param: String title, String message
	 */
	private void clearText(JTextField txt) {
		txt.setText(" ");
		txt.setText("");
	}
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Shows a popup error dialog
	 * @param: String title, String message
	 */
	private void showError(String title, String message) {
		//custom title, error icon
		JOptionPane.showMessageDialog(frame,
		    message,
		    title,
		    JOptionPane.ERROR_MESSAGE);
	}
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Clears all textFields.
	 */
	private void clearBoxes() {
		//Clear
		clearText(txtUsername);
		clearText(txtFirstName);
		clearText(txtLastName);
		clearText(txtPassword1);
		clearText(txtPassword2);
		clearText(txtAge);
	}
	
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Resets all the highlights under textFields.
	 */
	private void resetHighlights() {
		String username = txtUsername.getText().toString();
		String firstName = txtFirstName.getText().toString();
		String lastName = txtLastName.getText().toString();
		String age = txtAge.getText().toString();

		pUsername.setBackground(hex2Rgb("#011A27"));
		pFirstName.setBackground(hex2Rgb("#011A27"));
		pLastName.setBackground(hex2Rgb("#011A27"));
		pPassword1.setBackground(hex2Rgb("#011A27"));
		pPassword2.setBackground(hex2Rgb("#011A27"));
		pAge.setBackground(hex2Rgb("#011A27"));
		
		txtUsername.setText(username);
		txtFirstName.setText(firstName);
		txtLastName.setText(lastName);
		txtAge.setText(age);

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
