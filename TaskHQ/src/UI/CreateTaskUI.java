package UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class CreateTaskUI {

	private JFrame frame;
	private JTextField txtAddress;
	private JTextArea txtDescription;
	private JFormattedTextField txtStartDate, txtTaskStartTime, txtEndDate, txtEndTime;
	private JPanel pStartDate, pStartTime, pEndTime, pEndDate, pAddress, panel;
	private JTextField txtSkill;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTaskUI window = new CreateTaskUI();
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
	public CreateTaskUI() {
		try {
			initialize();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.getContentPane().setBackground(CreateAccountUI.hex2Rgb("#F0810F"));
		frame.setBounds(100, 100, 568, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Comfortaa", Font.BOLD, 15));
		tabbedPane.setBounds(11, 11, 531, 298);
		frame.getContentPane().add(tabbedPane);
		
		JPanel pTaskTime = new JPanel();
		tabbedPane.addTab("Task Time", null, pTaskTime, null);
		pTaskTime.setLayout(null);
		
		txtStartDate = new JFormattedTextField(new MaskFormatter("####-##-##"));
		txtStartDate.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtStartDate.setBounds(11, 30, 234, 20);
		pTaskTime.add(txtStartDate);
		
		pStartDate = new JPanel();
		pStartDate.setBackground(new Color(1, 26, 39));
		pStartDate.setBounds(10, 30, 234, 23);
		pTaskTime.add(pStartDate);
		
		JLabel lblStartDate = new JLabel("Task Start Date (yyyy-MM-dd) *");
		lblStartDate.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblStartDate.setBounds(11, 11, 245, 14);
		pTaskTime.add(lblStartDate);
		
		txtTaskStartTime = new JFormattedTextField(new MaskFormatter("##:##"));
		txtTaskStartTime.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtTaskStartTime.setBounds(11, 87, 234, 20);
		pTaskTime.add(txtTaskStartTime);
		
		pStartTime = new JPanel();
		pStartTime.setBackground(new Color(1, 26, 39));
		pStartTime.setBounds(10, 87, 234, 23);
		pTaskTime.add(pStartTime);
		
		JLabel lblTaskStartTime = new JLabel("Task Start Time (HH:mm) *");
		lblTaskStartTime.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblTaskStartTime.setBounds(11, 68, 234, 14);
		pTaskTime.add(lblTaskStartTime);
		
		txtEndDate = new JFormattedTextField(new MaskFormatter("####-##-##"));
		txtEndDate.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtEndDate.setBounds(11, 167, 234, 20);
		pTaskTime.add(txtEndDate);
		
		pEndDate = new JPanel();
		pEndDate.setBackground(new Color(1, 26, 39));
		pEndDate.setBounds(10, 167, 234, 23);
		pTaskTime.add(pEndDate);
		
		JLabel lblEndDate = new JLabel("Task End Date (yyyy-MM-dd) *");
		lblEndDate.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblEndDate.setBounds(11, 148, 234, 14);
		pTaskTime.add(lblEndDate);
		
		txtEndTime = new JFormattedTextField(new MaskFormatter("##:##"));
		txtEndTime.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtEndTime.setBounds(11, 224, 234, 20);
		pTaskTime.add(txtEndTime);
		
		pEndTime = new JPanel();
		pEndTime.setBackground(new Color(1, 26, 39));
		pEndTime.setBounds(10, 224, 234, 23);
		pTaskTime.add(pEndTime);
		
		JLabel lblEndTime = new JLabel("Task End Time (HH:mm) *");
		lblEndTime.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblEndTime.setBounds(11, 205, 234, 14);
		pTaskTime.add(lblEndTime);
		
		JButton btnNext1 = new JButton("Next");
		btnNext1.setFont(new Font("Comfortaa", Font.BOLD, 11));
		btnNext1.setBounds(427, 232, 89, 23);
		btnNext1.addActionListener(new java.awt.event.ActionListener(){
		     public void actionPerformed(ActionEvent e){  
		         tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
		     }    
		 });
		pTaskTime.add(btnNext1);
		
		JPanel pLocation = new JPanel();
		tabbedPane.addTab("Location", null, pLocation, null);
		pLocation.setLayout(null);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Comfortaa", Font.PLAIN, 11));
		txtAddress.setColumns(10);
		txtAddress.setBackground(Color.WHITE);
		txtAddress.setBounds(10, 26, 271, 20);
		pLocation.add(txtAddress);
		
		pAddress = new JPanel();
		pAddress.setBackground(new Color(1, 26, 39));
		pAddress.setBounds(10, 26, 271, 23);
		pLocation.add(pAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		lblAddress.setBounds(11, 11, 108, 14);
		pLocation.add(lblAddress);
		
		JButton btnNext2 = new JButton("Next");
		btnNext2.setFont(new Font("Comfortaa", Font.BOLD, 11));
		btnNext2.setBounds(427, 232, 89, 23);
		btnNext2.addActionListener(new java.awt.event.ActionListener(){
		     public void actionPerformed(ActionEvent e){  
		         tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
		     }    
		 });
		pLocation.add(btnNext2);
		
		JPanel pPay = new JPanel();
		tabbedPane.addTab("Pay", null, pPay, null);
		pPay.setLayout(null);
		
		final JRadioButton rdPayed = new JRadioButton("Payed Work");
		rdPayed.setSelected(true);
		rdPayed.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		rdPayed.setBounds(6, 7, 117, 23);
		pPay.add(rdPayed);
		
		final JRadioButton rdVolunteer = new JRadioButton("Volunteer Work");
		rdVolunteer.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		rdVolunteer.setBounds(124, 7, 187, 23);
		pPay.add(rdVolunteer);
		
		   //Group the radio buttons.
			ButtonGroup group = new ButtonGroup();
			group.add(rdPayed);
			group.add(rdVolunteer);
			
			final JPanel pPayedWork = new JPanel();
			pPayedWork.setBackground(Color.WHITE);
			pPayedWork.setBounds(6, 37, 392, 218);
			pPay.add(pPayedWork);
			pPayedWork.setLayout(null);
			
			rdPayed.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			    	pPayedWork.setVisible(true);
			     }    
			 });
			
			rdVolunteer.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			    	pPayedWork.setVisible(false);
			     }    
			 });
			
			SpinnerModel sm = new SpinnerNumberModel(50, 1, 2500, 1);
			final JSpinner spPay = new JSpinner(sm);
			spPay.setEditor(new JSpinner.DefaultEditor(spPay));
			spPay.setFont(new Font("Comfortaa", Font.BOLD, 15));
			spPay.setBounds(10, 34, 89, 20);
			pPayedWork.add(spPay);
			
			JLabel lblTotalPay = new JLabel("Total Pay (CAD)");
			lblTotalPay.setFont(new Font("Comfortaa", Font.PLAIN, 15));
			lblTotalPay.setBounds(10, 11, 140, 20);
			pPayedWork.add(lblTotalPay);
			
			final JRadioButton rbInCash = new JRadioButton("Paying in Cash");
			rbInCash.setBackground(Color.WHITE);
			rbInCash.setFont(new Font("Comfortaa", Font.PLAIN, 15));
			rbInCash.setBounds(6, 61, 140, 23);
			pPayedWork.add(rbInCash);
			
			final JRadioButton rbInApp = new JRadioButton("Payment in App");
			rbInApp.setSelected(true);
			rbInApp.setBackground(Color.WHITE);
			rbInApp.setFont(new Font("Comfortaa", Font.PLAIN, 15));
			rbInApp.setBounds(148, 61, 147, 23);
			pPayedWork.add(rbInApp);
			
			//Group the radio buttons.
			ButtonGroup group2 = new ButtonGroup();
			group2.add(rbInCash);
			group2.add(rbInApp);
			
			JButton btnNext3 = new JButton("Next");
			btnNext3.setFont(new Font("Comfortaa", Font.BOLD, 11));
			btnNext3.setBounds(427, 232, 89, 23);
			btnNext3.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			         tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
			     }    
			 });
			pPay.add(btnNext3);
			
			JPanel pSkills = new JPanel();
			tabbedPane.addTab("Required Skills", null, pSkills, null);
			pSkills.setLayout(null);
			
			txtSkill = new JTextField();
			txtSkill.setBackground(Color.WHITE);
			txtSkill.setFont(new Font("Comfortaa", Font.PLAIN, 15));
			txtSkill.setBounds(10, 30, 365, 23);
			pSkills.add(txtSkill);
			txtSkill.setColumns(10);
			
			final JPanel pSkill = new JPanel();
			pSkill.setBackground(Color.BLACK);
			pSkill.setBounds(10, 30, 365, 25);
			pSkills.add(pSkill);
			
			JLabel lblAddSkill = new JLabel("Skill");
			lblAddSkill.setFont(new Font("Comfortaa", Font.BOLD, 15));
			lblAddSkill.setBounds(10, 11, 46, 14);
			pSkills.add(lblAddSkill);
			
			final DefaultListModel listModel = new DefaultListModel();
			
			JButton btnAddSkill = new JButton("Add Skill");
			//btnAddSkill.setBackground(CreateAccountUI.hex2Rgb("#F0810F"));
			btnAddSkill.setFont(new Font("Comfortaa", Font.BOLD, 15));
			btnAddSkill.setBounds(10, 64, 365, 23);
			
			btnAddSkill.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			   		//pSkill.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
		    		frame.repaint();
			    	 String skill = txtSkill.getText().toString();
			    	if (skill.length() != 0) {
			    		listModel.addElement(skill);
			    	} else {
			    		showError("Oops!","Write a skill!");
			    		txtSkill.setText("");
			    		pSkill.setBackground(Color.RED);
			    		frame.repaint();
			    	}
			     }    
			 });
			pSkills.add(btnAddSkill);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 98, 365, 157);
			
			JList lSkills = new JList(listModel);
			lSkills.setBounds(10, 99, 365, 156);
			scrollPane.setViewportView(lSkills);
			pSkills.add(scrollPane);
			
			JButton btnNext4 = new JButton("Next");
			btnNext4.setFont(new Font("Comfortaa", Font.BOLD, 11));
			btnNext4.setBounds(427, 232, 89, 23);
			btnNext4.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			         tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
			     }    
			 });
			pSkills.add(btnNext4);
			
			JPanel pDescription = new JPanel();
			tabbedPane.addTab("Description", null, pDescription, null);
			pDescription.setLayout(null);
			
			txtDescription = new JTextArea();
			pDescription.add(txtDescription);
			txtDescription.setBounds(10, 36, 506, 219);
			
			JLabel lblTaskDescription = new JLabel("Description *");
			lblTaskDescription.setFont(new Font("Comfortaa", Font.BOLD, 15));
			lblTaskDescription.setBounds(10, 11, 131, 14);
			pDescription.add(lblTaskDescription);
			
			panel = new JPanel();
			panel.setBounds(10, 36, 506, 225);
			pDescription.add(panel);
			panel.setBackground(Color.BLACK);

			
			JButton btnCreateTask = new JButton("Create Task");
			btnCreateTask.setFont(new Font("Comfortaa", Font.BOLD, 15));
			btnCreateTask.setBackground(Color.WHITE);
			btnCreateTask.setBounds(11, 332, 531, 27);
			
			btnCreateTask.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			    	// resetHighlights();
			    	 
			    	 String startDate = txtStartDate.getText().toString();
			    	 String startTime = txtTaskStartTime.getText().toString();
			    	 String endDate = txtEndDate.getText().toString();
			    	 String endTime = txtEndTime.getText().toString();
			    	 String address = txtAddress.getText().toString();
			    	 boolean payed = rdPayed.isSelected();
			    	 boolean volunteer = rdVolunteer.isSelected();
			    	 String pay = spPay.getValue().toString();
			    	 boolean cash = rbInCash.isSelected();
			    	 boolean inApp = rbInApp.isSelected();
			    	 ArrayList skills = new ArrayList();
			    	 String description = txtDescription.getText().toString();
			    	 
			    	 for (int i = 0; i < listModel.getSize(); i++) {
			    		 skills.add(listModel.getElementAt(i));
			    	 }
			
			    	 if (startDate.length() != 0 && startTime.length() != 0 && endDate.length() != 0 &&
			    			 endTime.length() != 0 && address.length() != 0 && description.length() != 0) {
			    		 if (description.length() < 100) {
			    			 if (countLines(description) < 5) {
			    				 /*
			    				  * TODO Create Task
			    				  */
			    			 } else {
			    				 showError("Oops!","Your description must be less than 5 lines!");
					     		 panel.setBackground(Color.RED);
					     		 frame.repaint();
			    			 }
			    		 } else {
			    			 showError("Oops!","Your description must be less than 100 characters!");
				     		 panel.setBackground(Color.RED);
				     		 frame.repaint();
			    		 }
			    	 } else {
			    		 showError("Oops!","You need to fill in all required fields on all tabs!");
			    		 pStartDate.setBackground(Color.RED);
			     		 pStartTime.setBackground(Color.RED);
			     		 pEndDate.setBackground(Color.RED);
			     		 pEndTime.setBackground(Color.RED);
			    		 pAddress.setBackground(Color.RED);
			     		 panel.setBackground(Color.RED);
			     		 frame.repaint();
			    	 }
			    	 
			    	 
			    	 System.out.println(startDate);
			     }
			});
			
			frame.getContentPane().add(btnCreateTask);
			
			JLabel lblManditory = new JLabel("* = Required Field");
			lblManditory.setHorizontalAlignment(SwingConstants.CENTER);
			lblManditory.setFont(new Font("Comfortaa", Font.BOLD, 13));
			lblManditory.setBounds(10, 309, 532, 14);
			frame.getContentPane().add(lblManditory);
	}
	
	
	private static int countLines(String str){
		   String[] lines = str.split("\r\n|\r|\n");
		   return  lines.length;
		}
	
	/*
	 * @author: Eric Klassen
	 * @date: 1/9/2019
	 * @desc: Resets all the highlights under textFields.
	 */
	/*
	private void resetHighlights() {
		
		 pStartDate.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
 		 pStartTime.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
 		 pEndDate.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
 		 pEndTime.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
		 pAddress.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
 		 panel.setBackground(CreateAccountUI.hex2Rgb("#011A27"));
		frame.repaint();
	}
	*/
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
}

