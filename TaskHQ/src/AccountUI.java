import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AccountUI {

	private JFrame frmAccountInformation;
	private JTextField txtPhoneNumber;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountUI window = new AccountUI();
					window.frmAccountInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccountInformation = new JFrame();
		frmAccountInformation.setResizable(false);
		frmAccountInformation.setTitle("Account Information");
		frmAccountInformation.getContentPane().setBackground(new Color(245, 245, 245));
		frmAccountInformation.setBounds(100, 100, 783, 393);
		frmAccountInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Email: ");
		lblUsername.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		JLabel lblBio = new JLabel("Bio: ");
		lblBio.setVerticalAlignment(SwingConstants.TOP);
		lblBio.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		JTextArea txtBio = new JTextArea();
		txtBio.setForeground(new Color(0, 0, 0));
		txtBio.setRows(10);
		JScrollPane sp = new JScrollPane(txtBio);
		txtBio.setLineWrap(true);
		txtBio.setFont(new Font("Comfortaa", Font.PLAIN, 14));
		txtBio.setText("Max. 150 characters");
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
					JOptionPane.showMessageDialog(frmAccountInformation, "Bio exceeds character limit (max 150 characters)", "Bio Error",
					        JOptionPane.WARNING_MESSAGE);
				}
				else{
				txtBio.setText(txtBio.getText());
				JOptionPane.showMessageDialog(null, "Bio Saved \n"+txtBio.getText(), "Bio", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnEditBio.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		JButton btnEditPhone = new JButton("Update Phone ");
		btnEditPhone.setBorder(new LineBorder(Color.black,4,true));

		btnEditPhone.setForeground(new Color(0, 0, 0));
		btnEditPhone.setBackground(new Color(255, 140, 0));
		btnEditPhone.addActionListener(new ActionListener() {
			//String newPhoneNumber
			public void actionPerformed(ActionEvent arg0) {
				if(txtPhoneNumber.getText().length()>12){
					JOptionPane.showMessageDialog(frmAccountInformation, "Please follow phone number format", "Number Error",
					        JOptionPane.WARNING_MESSAGE);
					txtPhoneNumber.setText("###-###-####");
				}
				else{
				txtPhoneNumber.setText(txtPhoneNumber.getText());;
				JOptionPane.showMessageDialog(null, "Phone Number Saved \n"+txtPhoneNumber.getText(), "Phone Number", JOptionPane.INFORMATION_MESSAGE);
				}}
			
		});
		
		btnEditPhone.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		
		JLabel lblSkills = new JLabel("Skills: ");
		lblSkills.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		JTextArea txtSkills = new JTextArea();
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
		btnEditSkills.setBackground(new Color(255, 140, 0));
		btnEditSkills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSkills.getText().length()>300){
					JOptionPane.showMessageDialog(frmAccountInformation, "Skills exceeds character limit (max 150 characters)", "Skills Error",
					        JOptionPane.WARNING_MESSAGE);
				}
				else{
				txtSkills.setText(txtSkills.getText());
				JOptionPane.showMessageDialog(null, "Skills Saved \n"+txtSkills.getText(), "Skills", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnEditSkills.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("###-###-####");
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
		JLabel lblUsernameText = new JLabel("gleb@zvonkov.com");
		lblUsernameText.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		JLabel lblAgeText = new JLabel("18");
		lblAgeText.setFont(new Font("Comfortaa", Font.PLAIN, 18));
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmAccountInformation.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(18)
									.addComponent(lblUsernameText, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBio, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
								.addComponent(sp, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblAgeText, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnEditPhone, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
								.addComponent(sp2, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSkills)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(btnEditBio, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(289)
							.addComponent(btnEditSkills)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblUsernameText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAgeText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
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
						.addComponent(sp, 0, 0, Short.MAX_VALUE)
						.addComponent(sp2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditBio, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditSkills, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		
		frmAccountInformation.getContentPane().setLayout(groupLayout);
	}
}
