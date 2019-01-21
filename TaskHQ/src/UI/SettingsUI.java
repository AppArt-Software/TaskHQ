package UI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import baseClasses.Account;
import baseClasses.Bio;



public class SettingsUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsUI window = new SettingsUI(new Account("","","","",0));
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
	public SettingsUI(Account currentUser) {
		initialize(currentUser);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Account currentUser) {
		Bio currentBio = currentUser.getBio();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 428);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel=new JPanel();
		panel.setBackground(Color.WHITE);
		
		 
		JLabel lblUsername = new JLabel("Email: ");
		lblUsername.setFont(new Font("Comfortaa", Font.BOLD, 18));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Comfortaa", Font.BOLD, 18));
		
		JLabel lblBio = new JLabel("Bio: ");
		lblBio.setVerticalAlignment(SwingConstants.TOP);
		lblBio.setFont(new Font("Comfortaa", Font.BOLD, 18));
		final JTextArea txtBio = new JTextArea();
		txtBio.setForeground(new Color(0, 0, 0));
		txtBio.setRows(10);
		JScrollPane sp = new JScrollPane(txtBio);
		txtBio.setLineWrap(true);
		txtBio.setFont(new Font("Comfortaa", Font.PLAIN, 14));
		txtBio.setText(currentBio.getDescription());
		if(txtBio.getText().equals("")){
		txtBio.setText("Max. 150 characters");
		}

		txtBio.addFocusListener(new FocusListener(){
			String bioText = "Max. 150 characters";
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtBio.getText().equals(bioText)){
				txtBio.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtBio.getText().equals("")){
					txtBio.setText("Max. 150 characters");
				
				}
			}
			
		});
		JButton btnEditBio = new JButton("Update Bio");
		btnEditBio.setBorder(new LineBorder(Color.black,4,true));
		btnEditBio.setOpaque(true);
		btnEditBio.setBackground(new Color(255, 140, 0));
		btnEditBio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtBio.getText().length()>150){
					JOptionPane.showMessageDialog(frame, "Bio exceeds character limit (max 150 characters)", "Bio Error",
					        JOptionPane.WARNING_MESSAGE);
				}
				else{
				currentUser.getBio().setDescription(txtBio.getText());
				currentUser.updateAccount();

				txtBio.setText(txtBio.getText());
				JOptionPane.showMessageDialog(null, "Bio Saved \n"+txtBio.getText(), "Bio", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnEditBio.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Comfortaa", Font.BOLD, 18));
		
		JButton btnEditPhone = new JButton("Update Phone ");
		btnEditPhone.setBorder(new LineBorder(Color.black,4,true));
		btnEditPhone.setForeground(new Color(0, 0, 0));
		btnEditPhone.setOpaque(true);
		btnEditPhone.setBackground(new Color(255, 140, 0));
		
		
		btnEditPhone.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		
		JLabel lblSkills = new JLabel("Skills: ");
		lblSkills.setFont(new Font("Comfortaa", Font.BOLD, 18));
		final JTextArea txtSkills = new JTextArea();
		JScrollPane sp2 = new JScrollPane(txtSkills);
		txtSkills.setText("Max. 300 Characters");
		txtSkills.setRows(12);
		txtSkills.setLineWrap(true);
		txtSkills.setFont(new Font("Comfortaa", Font.PLAIN, 14));
		txtSkills.addFocusListener(new FocusListener(){
			String skillsText = "Max. 300 Characters";
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtSkills.getText().equals(skillsText)){
				txtSkills.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtSkills.getText().equals("")){
					txtSkills.setText(skillsText);
				}
				
			}
			
		});
		JButton btnEditSkills = new JButton("Update Skills");
		btnEditSkills.setBorder(new LineBorder(Color.black,4,true));
		btnEditSkills.setOpaque(true);
		btnEditSkills.setBackground(new Color(255, 140, 0));
		btnEditSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSkills.getText().length()>300){
					JOptionPane.showMessageDialog(frame, "Skills exceeds character limit (max 150 characters)", "Skills Error",
					        JOptionPane.WARNING_MESSAGE);
				}
				else{
					
					//add update
					
				currentUser.getBio().setSkills(txtSkills.getText());
				currentUser.updateAccount();
				txtSkills.setText(txtSkills.getText());
				JOptionPane.showMessageDialog(null, "Skills Saved \n"+txtSkills.getText(), "Skills", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnEditSkills.setFont(new Font("Comfortaa", Font.PLAIN, 13));
			
		final JTextField txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText(currentBio.getPhoneNumber());
		if(txtPhoneNumber.getText().equals("")){
		txtPhoneNumber.setText("###-###-####");
		}
		
		txtPhoneNumber.setFont(new Font("Comfortaa", Font.PLAIN, 16));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.addFocusListener(new FocusListener(){
			String numText = "###-###-####";
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtPhoneNumber.getText().equals(numText)){
				txtPhoneNumber.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtPhoneNumber.getText().equals("")){
					txtPhoneNumber.setText("###-###-####");
				}
				
			}
			
		});
		
		btnEditPhone.addActionListener(new ActionListener() {
			//String newPhoneNumber
			public void actionPerformed(ActionEvent arg0) {
				if(txtPhoneNumber.getText().length()>12){
					JOptionPane.showMessageDialog(frame, "Please follow phone number format", "Number Error",
					        JOptionPane.WARNING_MESSAGE);
					txtPhoneNumber.setText("###-###-####");
				}
				else{
					currentUser.getBio().setPhoneNumber(txtPhoneNumber.getText());
					currentUser.updateAccount();

				txtPhoneNumber.setText(txtPhoneNumber.getText());;
				JOptionPane.showMessageDialog(null, "Phone Number Saved \n"+txtPhoneNumber.getText(), "Phone Number", JOptionPane.INFORMATION_MESSAGE);
				}}
			
		});
		
		
		
		JTextField txtAge = new JTextField();
		txtAge.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		txtAge.setText(Integer.toString(currentUser.getAge()));
		txtAge.setColumns(10);
		JLabel lblUsernameText = new JLabel(currentUser.getUsername());//
		lblUsernameText.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		JButton btnUpdateAge = new JButton("Update Age");
		btnUpdateAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				currentUser.setAge(Integer.parseInt(txtAge.getText()));
				currentUser.updateAccount();
				
				txtAge.setText(txtAge.getText());
				JOptionPane.showMessageDialog(null, "Age Saved \n"+txtAge.getText(), "Age", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnUpdateAge.setOpaque(true);
		btnUpdateAge.setForeground(Color.BLACK);
		btnUpdateAge.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		btnUpdateAge.setBorder(new LineBorder(Color.black,4,true));
		btnUpdateAge.setBackground(new Color(255, 140, 0));
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(panel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(18)
									.addComponent(lblUsernameText, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBio, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(sp, 0, 0, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEditPhone, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSkills)
								.addComponent(sp2, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnUpdateAge, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(btnEditBio, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(289)
							.addComponent(btnEditSkills)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblUsernameText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdateAge, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditPhone, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSkills, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(sp2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditBio, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditSkills, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		
		panel.setLayout(groupLayout);
		
	  frame.getContentPane().add(panel);
	  
	  frame.setVisible(true);
	}

}