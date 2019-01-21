package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import baseClasses.Account;
import baseClasses.CeasarCipher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginUI {

	private JFrame frame;
	private static JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPanel pPassword, pEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
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
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 307, 179);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(10, 72, 271, 20);
		frame.getContentPane().add(txtPassword);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(10, 26, 271, 20);
		frame.getContentPane().add(txtEmail);
		
		pEmail = new JPanel();
		pEmail.setBackground(new Color(1, 26, 39));
		pEmail.setBounds(10, 26, 271, 23);
		frame.getContentPane().add(pEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblEmail.setBounds(11, 11, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblPassword.setBounds(11, 57, 110, 14);
		frame.getContentPane().add(lblPassword);
		
		pPassword = new JPanel();
		pPassword.setBackground(new Color(1, 26, 39));
		pPassword.setBounds(10, 72, 271, 23);
		frame.getContentPane().add(pPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(1, 26, 39));
		btnLogin.setFont(new Font("Comfortaa", Font.BOLD, 15));
		btnLogin.setBackground(new Color(240, 129, 15));
		btnLogin.setBounds(51, 103, 172, 23);
		
		btnLogin.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pEmail.setBackground(Color.BLACK);
				pPassword.setBackground(Color.BLACK);
				frame.repaint();
				
				String username = txtEmail.getText().toString();
				String password = new String(txtPassword.getPassword());
				CeasarCipher cc = new CeasarCipher(password);
				password=cc.getOutput();
				if (username.length() != 0 && password.length() != 0) {
					if (username.contains("@")) {
						//to do check user info
						if(Account.parseJSON(Account.getAccount(username), 0, "password").trim().equals(password.trim())){
							MainUI viewMain = new MainUI();
							viewMain.main(null);
							
						}
						else{
							showError("Oops!","Incorrect email or password enetered, please try again!");
							pPassword.setBackground(Color.RED);
							txtPassword.setText("");
							frame.repaint();
						}
						
					} else {
						showError("Oops!","Invalid email! (Does not contain '@')");
						pEmail.setBackground(Color.RED);
						txtEmail.setText("");
						frame.repaint();
					}
				} else {
					showError("Oops!","You must fill in all boxes!");
					pEmail.setBackground(Color.RED);
					pPassword.setBackground(Color.RED);
					frame.repaint();
				}
			}
		});
		
		
		frame.getContentPane().add(btnLogin);
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
	static String getUsername(){
		return txtEmail.getText();
	}
}