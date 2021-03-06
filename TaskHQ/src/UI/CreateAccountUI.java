package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import baseClasses.Account;
import baseClasses.CeasarCipher;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
/*
 * @author: Eric Klassen
 * @desc: Screen to create account. Contains all the mandatory input areas
 * @date: 12/20/2018
 */
public class CreateAccountUI {

	private JFrame frame;//Main frame
	private JTextField txtUsername;//Username input
	private JTextField txtFirstName;//First Name input
	private JTextField txtLastName;//Last Name input
	private JPasswordField txtPassword1;//Password input
	private JPasswordField txtPassword2;//Password confirmation input
	private JPanel pUsername, pFirstName, pLastName, pPassword1, pPassword2;//Highlight panels
	private JPanel pAge;//Spinner highlight panel
	private JSpinner sAge;//Age spinner

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
		frame.setBounds(100, 100, 307, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Age spinner
		SpinnerModel sm = new SpinnerNumberModel(13, 13, 110, 1); //default value,lower bound,upper bound,increment by
		sAge = new JSpinner(sm);
		sAge.setEditor(new JSpinner.DefaultEditor(sAge));
		sAge.setFont(new Font("Comfortaa", Font.BOLD, 15));
		sAge.setBounds(10, 264, 89, 20);
		
		frame.getContentPane().add(sAge);
		//Username input
		txtUsername = new JTextField();
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtUsername.setBounds(10, 26, 271, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		//Username title
		JLabel lblTUsername = new JLabel("Email");
		lblTUsername.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblTUsername.setBounds(11, 11, 46, 14);
		frame.getContentPane().add(lblTUsername);
		//First name input
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(10, 72, 271, 20);
		frame.getContentPane().add(txtFirstName);
		//First name title
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblFirstName.setBounds(11, 57, 140, 14);
		frame.getContentPane().add(lblFirstName);
		//Last name input
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 118, 271, 20);
		frame.getContentPane().add(txtLastName);
		//Last name title
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblLastName.setBounds(11, 103, 140, 14);
		frame.getContentPane().add(lblLastName);
		//Password title
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblPassword.setBounds(11, 149, 140, 14);
		frame.getContentPane().add(lblPassword);
		//Password input 
		txtPassword1 = new JPasswordField();
		txtPassword1.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtPassword1.setBounds(10, 164, 271, 20);
		frame.getContentPane().add(txtPassword1);
		//Password input confirmation
		txtPassword2 = new JPasswordField();
		txtPassword2.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtPassword2.setBounds(10, 210, 271, 20);
		frame.getContentPane().add(txtPassword2);
		//Password confirmation title
		JLabel lblRepeatPass = new JLabel("Repeat Password");
		lblRepeatPass.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblRepeatPass.setBounds(11, 195, 140, 14);
		frame.getContentPane().add(lblRepeatPass);
		//Create account button
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setForeground(hex2Rgb("#011A27"));
		btnCreateAccount.setBackground(hex2Rgb("#F0810F"));
		btnCreateAccount.setFont(new Font("Comfortaa", Font.BOLD, 15));
		btnCreateAccount.setBounds(109, 263, 172, 23);	
		frame.getContentPane().add(btnCreateAccount);
		//Username highlight
		pUsername = new JPanel();
		pUsername.setBackground(hex2Rgb("#011A27"));
		pUsername.setBounds(10, 26, 271, 23);
		frame.getContentPane().add(pUsername);
		//First name highlight
		pFirstName = new JPanel();
		pFirstName.setBackground(hex2Rgb("#011A27"));
		pFirstName.setBounds(10, 72, 271, 23);
		frame.getContentPane().add(pFirstName);
		//Last name highlight
		pLastName = new JPanel();
		pLastName.setBackground(hex2Rgb("#011A27"));
		pLastName.setBounds(10, 118, 271, 23);
		frame.getContentPane().add(pLastName);
		//password highlight
		pPassword1 = new JPanel();
		pPassword1.setBackground(hex2Rgb("#011A27"));
		pPassword1.setBounds(10, 164, 271, 23);
		frame.getContentPane().add(pPassword1);
		//Password confirmation highlight
		pPassword2 = new JPanel();
		pPassword2.setBackground(hex2Rgb("#011A27"));
		pPassword2.setBounds(10, 210, 271, 23);
		frame.getContentPane().add(pPassword2);
		//Age title
		JLabel lblAge = new JLabel("Age (Years)");
		lblAge.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblAge.setBounds(10, 241, 140, 20);
		frame.getContentPane().add(lblAge);
		//age spinner highlight
		pAge = new JPanel();
		pAge.setBackground(new Color(1, 26, 39));
		pAge.setBounds(10, 264, 89, 23);
		frame.getContentPane().add(pAge);
		//Email confirmation title
		JLabel lblConfirmation = new JLabel("A confirmation email will be sent to the provided address.");
		lblConfirmation.setFont(new Font("Comfortaa", Font.PLAIN, 8));
		lblConfirmation.setBounds(10, 301, 271, 36);
		frame.getContentPane().add(lblConfirmation);
		//When create account is pressed
		btnCreateAccount.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resetHighlights();//Reset highlights
				//Getting input
				String username = txtUsername.getText().toString();
				String firstName = txtFirstName.getText().toString();
				String lastName = txtLastName.getText().toString();
				String password1 = new String(txtPassword1.getPassword());
				String password2 = new String (txtPassword2.getPassword());
				String age = sAge.getValue().toString();
				//Check to make sure all inputs are complete
				if (username.trim().length() != 0 && firstName.trim().length() != 0 &&
						lastName.trim().length() != 0 && password1.length() != 0 &&
						password2.length() !=  0) {
						//Check that email contains '@'
						if (username.contains("@")) {
							//Confirm that the passwords match
							if (password1.equals(password2)) {
								//Confirm that passwords are more than 6 characters
								if (password1.length() > 6) {
									CeasarCipher cc = new CeasarCipher(password2);//ENCODE for SECURITY!!
									password2=cc.getOutput();
									//Create account on database
									Account newAccount = new Account(username, firstName, lastName, password2, Integer.parseInt(age));
									newAccount.createAccount();
								
									//display message
	    							JOptionPane.showMessageDialog(frame,
	    							    "You have created an account! Now login to enter TaskHQ!",
	    							    "Congrats!",
	    							    JOptionPane.INFORMATION_MESSAGE);
	    							
	    						frame.dispose();
									
								} else {
									clearText(txtPassword1);
									clearText(txtPassword2);
									pPassword1.setBackground(Color.RED);
									pPassword2.setBackground(Color.RED);
									frame.repaint();
									showError("Oops!", "Your password must be greater than 6 characters long!");
								}				
							} else {
								clearText(txtPassword1);
								clearText(txtPassword2);
								pPassword1.setBackground(Color.RED);
								pPassword2.setBackground(Color.RED);
								frame.repaint();
								showError("Oops!", "Your passwords don't match!");
							}			
						} else {
							clearText(txtUsername);
							pUsername.setBackground(Color.RED);
							frame.repaint();
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
						frame.repaint();
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
	}
	
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Resets all the highlights under textFields.
	 */
	private void resetHighlights() {
		
		pUsername.setBackground(hex2Rgb("#011A27"));
		pFirstName.setBackground(hex2Rgb("#011A27"));
		pLastName.setBackground(hex2Rgb("#011A27"));
		pPassword1.setBackground(hex2Rgb("#011A27"));
		pPassword2.setBackground(hex2Rgb("#011A27"));
		pAge.setBackground(hex2Rgb("#011A27"));
		frame.repaint();
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