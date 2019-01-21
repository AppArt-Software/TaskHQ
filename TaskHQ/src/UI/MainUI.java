package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import baseClasses.Account;
import baseClasses.Bio;
import baseClasses.Task;

//import net.miginfocom.swing.MigLayout;
import java.sql.Timestamp;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
//import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Frame;

//add glebs ui and get task id to confirm picked up
//check boolean to see if it should be posted
//make array of tasks cnad check their booleans1
//match title thorugh array adn to get id of task, 
public class MainUI {
//fill in changes from word doc
	private static String userNameLog = LoginUI.getUsername();
	private JFrame frame;
	private JPanel panel_3 = new JPanel();
	private JTextField txtAddress;
	private JTextArea txtDescription;
	private JFormattedTextField txtStartDate, txtTaskStartTime, txtEndDate, txtEndTime;
	private JPanel pStartDate, pStartTime, pEndTime, pEndDate, pAddress, panel, pTitle;
	private JTextField txtSkill, txtTitle;
	private JTabbedPane tabbedPane;
	private static Account currentUser = fillAccountInfo(userNameLog);
	private static Bio currentBio =fillBioInfo(userNameLog);
	private JTextField txtAge;
	private String[] taskId, posted, approved, taskText, payText, dateText, employerText, authorText, locationText, startText, endText,
	skillsText, descriptionText; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		currentUser.setBio(currentBio);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
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
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(new Dimension(1150, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(255,140,0)));
		
		ImageIcon icon = new ImageIcon("TaskHQ");
		frame.setIconImage(icon.getImage());
			
		
		
		//new Color(255,140,0)
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();		
		panel_2.setBackground(Color.WHITE);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 878, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)))
					.addGap(343))
		);
		panel_3.setBackground(Color.WHITE);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)))
					.addGap(111))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		panel.add(logopanel());
		panel_1.add(accountpanel());
		panel_2.add(selectionpanel());
		panel_3.add(pickshiftpanel());
	}
	


public JPanel selectionpanel (){		
		JPanel panel= new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
        
		final JButton post= new JButton(" Post Task ");
		final JButton shift= new JButton("Pickup Task");
		//if(post.getModel().isPressed()) post.setBackground(Color.blue);
		post.setFont(new Font("Comfortaa", Font.BOLD, 20));
		shift.setFont(new Font("Comfortaa", Font.BOLD, 20));
		post.setBorder(new LineBorder(Color.black, 8, true));
		shift.setBorder(new LineBorder(Color.black, 8, true));
		shift.setOpaque(true);
		post.setOpaque(true);
		shift.setBackground(hex2Rgb("#F0810F")); 
		post.setBackground(hex2Rgb("#F0810F"));
		post.setPreferredSize(new Dimension(200, 200));
		shift.setPreferredSize(new Dimension(200, 200));
		final JPanel spanel= new JPanel();
		final JPanel ppanel= new JPanel();
		spanel.add(shift);
		ppanel.add(post);
		panel.add(spanel, BorderLayout.NORTH);	
		panel.add(Box.createRigidArea(new Dimension(0,30)));
		panel.add(ppanel, BorderLayout.SOUTH);
		spanel.setBackground(Color.black);
		
		shift.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
			panel_3.removeAll();
			panel_3.add(pickshiftpanel());
			spanel.setBackground(Color.black);
			ppanel.setBackground(Color.white);
			frame.validate();
			frame.repaint();
		 }});
		
		post.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
			panel_3.removeAll();
			try {
				panel_3.add(postshiftpanel());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ppanel.setBackground(Color.black);
			spanel.setBackground(Color.white);
			frame.validate();
			frame.repaint();
		 }});
				 
		post.addMouseListener(new MouseAdapter(){

		    @Override
		    public void mousePressed(MouseEvent e) {
		    	post.setBackground(Color.blue);
		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	post.setBackground(hex2Rgb("#F0810F"));
		    }

		});
		
		shift.addMouseListener(new MouseAdapter(){

		    @Override
		    public void mousePressed(MouseEvent e) {
		    	shift.setBackground(Color.blue);
		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	shift.setBackground(hex2Rgb("#F0810F"));
		    }

		});
		
		
		return panel;
	}


	
	
	public JPanel logopanel(){
		JPanel panel = new JPanel();	
		panel.setBackground(Color.WHITE);
		panel.add(new JLabel(new ImageIcon("logo2.png")));
		panel.setAlignmentX(JLabel.RIGHT);
		return panel;
	}
	
	public JPanel accountpanel (){
        JPanel inpanel=new JPanel ();
        inpanel.setBackground(Color.WHITE);
		JLabel name= new JLabel (currentUser.getFirstName()+" "+currentUser.getLastName());
		name.setFont(new Font("Comfortaa", Font.PLAIN, 40));
		final JButton button = new JButton(new ImageIcon("settings.png"));
		final JButton calendar=new JButton("My Tasks");
		calendar.setBorder(new LineBorder(Color.black, 4, true));
		calendar.setOpaque(true);
		calendar.setBackground(new Color(255,140,0));
		calendar.setPreferredSize(new Dimension(100, 53));
		button.setBorder(new LineBorder(Color.black, 4, true));
		
		inpanel.add(new JLabel(new ImageIcon("profile.png")));
		inpanel.add(name);
		inpanel.add(calendar);
		inpanel.add(button);	

		calendar.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
			new CalendarUI(currentUser,taskId, taskText, employerText, locationText, startText, endText, skillsText, descriptionText,
					posted, approved);
		 }});
		
		button.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
			new SettingsUI(currentUser);
		 }});
		
		
		calendar.addMouseListener(new MouseAdapter(){

		    @Override
		    public void mousePressed(MouseEvent e) {
		    	calendar.setBackground(Color.blue);
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	calendar.setBackground(new Color(255,140,0));
		    }

		});
		
		
		
		return inpanel;
	}
	
	
	
	public JPanel postshiftpanel() throws ParseException{
		JPanel p = new JPanel();
		p.setBackground(hex2Rgb("#F0810F"));	
		p.setPreferredSize(new Dimension(550, 400));
		p.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Comfortaa", Font.BOLD, 15));
		tabbedPane.setBounds(11, 11, 531, 298);
		p.add(tabbedPane);
		
		 JPanel pDescription = new JPanel();
	        tabbedPane.addTab("Description", null, pDescription, null);
	        pDescription.setLayout(null);
	        
	        txtDescription = new JTextArea();
	        pDescription.add(txtDescription);
	        txtDescription.setBounds(10, 82, 506, 141);
	        
	        JLabel lblTaskDescription = new JLabel("Description *");
	        lblTaskDescription.setFont(new Font("Comfortaa", Font.PLAIN, 15));
	        lblTaskDescription.setBounds(10, 57, 131, 14);
	        pDescription.add(lblTaskDescription);
	        
	        panel = new JPanel();
	        panel.setBounds(10, 101, 506, 130);
	        pDescription.add(panel);
	        panel.setBackground(Color.BLACK);
	        
	        txtTitle = new JTextField();
	        txtTitle.setFont(new Font("Comfortaa", Font.PLAIN, 11));
	        txtTitle.setColumns(10);
	        txtTitle.setBackground(Color.WHITE);
	        txtTitle.setBounds(10, 26, 271, 20);
	        pDescription.add(txtTitle);
	        
	        pTitle = new JPanel();
	        pTitle.setBackground(new Color(1, 26, 39));
	        pTitle.setBounds(10, 26, 271, 23);
	        pDescription.add(pTitle);
	        
	        JLabel lblTitle = new JLabel("Title *");
	        lblTitle.setFont(new Font("Comfortaa", Font.PLAIN, 15));
	        lblTitle.setBounds(11, 11, 108, 14);
	        pDescription.add(lblTitle);
	        
	        JButton btnNext4 = new JButton("Next");
	        btnNext4.setFont(new Font("Comfortaa", Font.BOLD, 11));
	        btnNext4.setBounds(427, 234, 89, 23);
	        btnNext4.addActionListener(new java.awt.event.ActionListener(){
	             public void actionPerformed(ActionEvent e){  
	                 tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex()+1);
	             }    
	         });
	        pDescription.add(btnNext4);
		
		
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
			
			final DefaultListModel<String> listModel = new DefaultListModel();
			
			JButton btnAddSkill = new JButton("Add Skill");
			btnAddSkill.setBackground(hex2Rgb("#F0810F"));
			btnAddSkill.setFont(new Font("Comfortaa", Font.BOLD, 15));
			btnAddSkill.setBounds(10, 64, 365, 23);
			
			btnAddSkill.addActionListener(new java.awt.event.ActionListener(){
			     public void actionPerformed(ActionEvent e){  
			   		pSkill.setBackground(hex2Rgb("#011A27"));
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
			
			JList<String> lSkills = new JList<String>(listModel);
			lSkills.setBounds(10, 99, 365, 156);
			scrollPane.setViewportView(lSkills);
			pSkills.add(scrollPane);
			
		
			
			JLabel lblManditory = new JLabel("* = Required Field");
			lblManditory.setHorizontalAlignment(SwingConstants.CENTER);
			lblManditory.setFont(new Font("Comfortaa", Font.BOLD, 13));
			lblManditory.setBounds(10, 309, 532, 14);
			p.add(lblManditory);
			
			JButton btnCreateTask = new JButton("Create Task");
			btnCreateTask.setBounds(11, 332, 531, 27);
			p.add(btnCreateTask);
			btnCreateTask.setFont(new Font("Comfortaa", Font.BOLD, 15));
			btnCreateTask.setBackground(Color.WHITE);
			
			btnCreateTask.addActionListener(new java.awt.event.ActionListener(){
			    
				public void actionPerformed(ActionEvent e){  
			    	 resetHighlights();
			    	 
			    	 String startDate = txtStartDate.getText().toString();
			    	 String startTime = txtTaskStartTime.getText().toString();
			    	 String endDate = txtEndDate.getText().toString();
			    	 String endTime = txtEndTime.getText().toString();
			    	 String address = txtAddress.getText().toString();
			    	 String title = txtTitle.getText().toString();
			    	 boolean payed = rdPayed.isSelected();
			    	 boolean volunteer = rdVolunteer.isSelected();
			    	 String pay = spPay.getValue().toString();
			    	 boolean cash = rbInCash.isSelected();
			    	 boolean inApp = rbInApp.isSelected();
			    	 ArrayList<String> skills = new ArrayList();
			    	 String description = txtDescription.getText().toString();
			    	 String appOrPerson="person";
			    	 for (int i = 0; i < listModel.getSize(); i++) {
			    		 skills.add(listModel.getElementAt(i));
			    	 }
			
			    	 if (startDate.length() != 0 && startTime.length() != 0 && endDate.length() != 0 &&
			    			 endTime.length() != 0 && address.length() != 0 && description.length() != 0) {
			    		 if (description.length() < 100) {
			    			 if (countLines(description) < 5) {
			    				 if(volunteer){
			    					 pay="0";
			    				 }
			    				 if(!volunteer){
			    				 if(cash){
			    					 appOrPerson="person";
			    				 }
			    				 else if(inApp){
			    					 appOrPerson="app";
			    				 }
			    				 }
			    				 else{
			    					 appOrPerson="person";
			    				 }
			    				 String start = startDate+" "+startTime;
			    				 String end = endDate+" "+endTime;
			    				 //Task(String title, Account author, double wage, String start, String end, String location, String description, String appOrPerson, String skillsRequired){
			    				 
			    				 
			    				 
			    				 Task newTask = new Task(title, currentUser, Double.parseDouble(pay),start, end, address, description,appOrPerson, skills.toString());
			    				
			    				 newTask.createTask();
			    				 
			    					panel_3.removeAll();
			    					panel_3.add(pickshiftpanel());
			    					frame.validate();
			    					frame.repaint();
			    				 
			    				//custom title, error icon
	    							JOptionPane.showMessageDialog(frame,
	    							    "Your task has been created!",
	    							    "Task Created!",
	    							    JOptionPane.INFORMATION_MESSAGE);
			    				//show confirmation, add to calendar 
			    				 
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
			     		 pTitle.setBackground(Color.RED);
			     		 frame.repaint();
			    	 }
			    	 
			    	 
			    	 //System.out.println(startDate);
			     }
			});
			
		return p;
	}
	
	public JPanel approveshiftpanel(){
		JPanel panel = new JPanel();
		
		return panel;
	}
	
	
	int lengthArrays = Task.numberOfTasks(Task.getTasks());

private JPanel [] bar= new JPanel[lengthArrays];
	private JLabel task []=new JLabel[lengthArrays];
	private JLabel pay[]=new JLabel[lengthArrays];
	private JLabel date[]=new JLabel[lengthArrays];
	
	public JPanel pickshiftpanel(){
		
		
		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(new LineBorder(Color.black, 6, true));
		panel.setBackground(hex2Rgb("#F0810F"));
		
		JPanel name=new JPanel();
		name.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		name.setBorder(new LineBorder(Color.black, 3, true));
		name.setBackground(hex2Rgb("#F0810F"));
		JLabel label=new JLabel(" Task");
		JLabel label2=new JLabel("    Pay");
		JLabel label3=new JLabel("    Date");
		label.setFont(new Font("Comfortaa", Font.PLAIN, 40));
		label2.setFont(new Font("Comfortaa", Font.PLAIN, 40));
		label3.setFont(new Font("Comfortaa", Font.PLAIN, 40));
		name.add(label);
		name.add(label2);
		name.add(label3);
		

	 //use current i value for title to match in database 
		JButton moreinfo[]=new JButton[lengthArrays];
		JButton pickup []=new JButton[lengthArrays];
		
		JScrollPane sp = new JScrollPane();
		sp.setPreferredSize((new Dimension(800,400)));
		
		JPanel list= new JPanel();
		list.setBackground(Color.WHITE);
		list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
		
		taskId = new String[lengthArrays];
		String parseStringId = Task.parseJSON(Task.getTasks().trim(),0, "id");
		taskId=parseStringId.split(" ");
		
		posted = new String[lengthArrays];
		String parseStringPosted = Task.parseJSON(Task.getTasks().trim(),1, "posted");
		posted=parseStringPosted.split(" ");
		
		approved = new String[lengthArrays];
		String parseStringApproved = Task.parseJSON(Task.getTasks().trim(),1, "completed");
		approved=parseStringApproved.split(" ");

		taskText = new String[lengthArrays];
		String parseStringTitles = Task.parseJSON(Task.getTasks().trim(),0, "title");
		taskText=parseStringTitles.split(" ");

		payText=new String[lengthArrays];
		String parseStringPay = Task.parseJSON(Task.getTasks(),0, "pay");
		payText=parseStringPay.split(" ");
		
		dateText=new String[lengthArrays*2];
		String parseStringDate = Task.parseJSON(Task.getTasks(),0, "start");
		System.out.println(parseStringDate);
		dateText=parseStringDate.split(" ");
		int datecount=0;
		
		employerText = new String[lengthArrays];
		for(int i=0; i<lengthArrays;i++){
			employerText[i]= Account.parseJSON(Account.getAccount(Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "author")), 0, "firstName")+" "+Account.parseJSON(Account.getAccount(Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "author")), 0, "lastName"); //get first/last name
		}
		authorText = new String [lengthArrays];
		for(int i=0;i<lengthArrays;i++){
		authorText[i]=Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "author");
		}
		

		locationText = new String[lengthArrays];
		for(int i=0; i<lengthArrays;i++){
			locationText[i] = Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "location");
		}
		
		startText = new String[lengthArrays];
		for(int i=0; i<lengthArrays;i++){
			startText[i] = Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "start");
		}
		endText = new String[lengthArrays];
		for(int i=0; i<lengthArrays;i++){
			endText[i] = Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "end");
		}
		skillsText = new String[lengthArrays];
		String nextSkill="";
		for(int i=0; i<lengthArrays;i++){
			nextSkill=Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "skillsRequired");
			skillsText[i]=nextSkill.substring(1, nextSkill.length()-2);
		}
		
		descriptionText = new String[lengthArrays];
		for(int i=0; i<lengthArrays;i++){
			descriptionText[i] = Task.parseJSONDetails(Task.getTaskDetails(Integer.parseInt(taskId[i])), "description");
		}

		final JPopupMenu pop2 = new JPopupMenu();
		pop2.setBorder(new LineBorder(Color.black, 4, true));
		pop2.add(confirmpanel());//parameter i then task details 
		for (int i=0 ; i < lengthArrays; i++) {		

			bar[i] = new JPanel();
			
			task [i]=new JLabel();
			pay[i]=new JLabel();
		    date[i]=new JLabel();
		    moreinfo[i]= new JButton();
		    pickup [i]= new JButton();
		    
		    task [i].setFont(new Font("Comfortaa", Font.PLAIN, 20));
		    pay[i].setFont(new Font("Comfortaa", Font.PLAIN, 20));
		    date[i].setFont(new Font("Comfortaa", Font.PLAIN, 20));
		    
		    task[i].setHorizontalAlignment(SwingConstants.LEFT);
		    task [i].setText(taskText[i].trim());
		    pay[i].setText("$" + Double.valueOf(payText[i].trim()));
		    date[i].setText(dateText[datecount].trim());
		    
		    moreinfo[i].setText("More Info");
		    moreinfo[i].setFont(new Font("Comfortaa", Font.PLAIN, 20));
		    moreinfo[i].setBorder(new LineBorder(Color.black, 4, true));
			moreinfo[i].setOpaque(true);
			moreinfo[i].setBackground(hex2Rgb("#F0810F"));
		    
			pickup[i].setText("Pick Up");
			pickup[i].setFont(new Font("Comfortaa", Font.PLAIN, 20));
			pickup[i].setBorder(new LineBorder(Color.black, 4, true));
			pickup[i].setOpaque(true);
		    pickup[i].setBackground(hex2Rgb("#F0810F"));
		   
			bar[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bar[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			
			
			bar[i].add(Box.createRigidArea(new Dimension(10,0)));
			bar[i].add(task[i]);
			bar[i].add(Box.createRigidArea(new Dimension(70,0)));
			bar[i].add(pay[i]);
			bar[i].add(Box.createRigidArea(new Dimension(70,0)));
			bar[i].add(date[i]);
			bar[i].add(Box.createRigidArea(new Dimension(70,0)));
			bar[i].add(moreinfo[i]);
			//Checking to see if employer = current user
			if (!employerText[i].equals(currentUser.getFirstName() + " " + currentUser.getLastName())) {
				bar[i].add(Box.createRigidArea(new Dimension(70,0)));
				bar[i].add(pickup[i]);
			}
			if (!posted[i].equals("0")) {
				list.add(bar[i]);	
				list.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			final int x=i;
			final int index=i;
			final String[] id = taskId;
			
			moreinfo[x].addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
				new TaskInfoUI(employerText[x], locationText[x], startText[x], endText[x], skillsText[x], descriptionText[x]);

			 }});	
			
			pickup[x].addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
				if(!pop2.isVisible()){
					for (int y=0 ; y < bar.length; y++) {
						bar[y].setBackground(Color.white);
						task [y].setForeground(Color.black);
						pay[y].setForeground(Color.black);
						date[y].setForeground(Color.black);	
					}
				}
				pop2.show(bar[x],0,40);  					
				bar[x].setBackground(Color.black);
				task [x].setForeground(Color.white);
				pay[x].setForeground(Color.white);
				date[x].setForeground(Color.white);	
				
				
				no.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) {
					pop2.setVisible(false);
					bar[x].setBackground(Color.white);
					task[x].setForeground(Color.black);
					pay[x].setForeground(Color.black);
					date[x].setForeground(Color.black);	
				}});
				
				yes.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) {
					pop2.setVisible(false);
					bar[x].setBackground(Color.white);
					task[x].setForeground(Color.black);
					pay[x].setForeground(Color.black);
					date[x].setForeground(Color.black);	
					Task.updateTaskStatus(Integer.parseInt(id[x]),false, true, false, false);
					list.remove(bar[x]);
					//custom title, error icon
					JOptionPane.showMessageDialog(frame,
					    "You have picked up a task! You can now view it's status on your calendar."
					    + "You must wait until it is approved by the employer before you can complete the task.",
					    "Congrats!",
					    JOptionPane.INFORMATION_MESSAGE);
					//whatever 
				}});

			}});
	datecount=datecount+2;
	
		}
		
		frame.addMouseListener((MouseListener) new CustomMouseListener());
		sp.addMouseListener(new CustomMouseListener());
		sp.setViewportView(list);
		panel.add(name);
		panel.add(sp);
		return panel;   
	}
	

	 class CustomMouseListener implements MouseListener {   //Chrisitan ur gonna have to create a new class according to ur needs, dont use this one
	      public void mouseClicked(MouseEvent e) {
	    	  for (int y=0 ; y < bar.length; y++) {
					bar[y].setBackground(Color.white);
					task [y].setForeground(Color.black);
					pay[y].setForeground(Color.black);
					date[y].setForeground(Color.black);	
				}
	      }
	      public void mousePressed(MouseEvent e) {
	      }
	      public void mouseReleased(MouseEvent e) {
	      }
	      public void mouseEntered(MouseEvent e) {
	      }
	      public void mouseExited(MouseEvent e) {
	      }
	   }
	
	
	private JButton yes=new JButton(" Yes ");

	private JButton no=new JButton(" No ");
	public JPanel confirmpanel(){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.black);
		
		yes.setFont(new Font("Comfortaa", Font.PLAIN, 20));
		yes.setBorder(new LineBorder(Color.black, 4, true));
		yes.setOpaque(true);
	    yes.setBackground(hex2Rgb("#F0810F"));
	    
	    no.setFont(new Font("Comfortaa", Font.PLAIN, 20));
		no.setBorder(new LineBorder(Color.black, 4, true));
		no.setOpaque(true);
	    no.setBackground(hex2Rgb("#F0810F"));
		
		
		JLabel label= new JLabel(" Are you sure you would like to pick up this task ? ");
		label.setFont(new Font("Comfortaa", Font.PLAIN, 20));
		label.setForeground(Color.white);
		panel.add(label, BorderLayout.NORTH);	
		
		JPanel panelbuttons=new JPanel();
		panelbuttons.setBackground(Color.black);
		panelbuttons.add(yes);
		panelbuttons.add(Box.createRigidArea(new Dimension(50,0)));
		panelbuttons.add(no);
		panel.add(panelbuttons, BorderLayout.SOUTH);
		
		yes.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
		
			}
		});
		
		return panel;
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
	private void resetHighlights() {
		
		 pStartDate.setBackground(hex2Rgb("#011A27"));
 		 pStartTime.setBackground(hex2Rgb("#011A27"));
 		 pEndDate.setBackground(hex2Rgb("#011A27"));
 		 pEndTime.setBackground(hex2Rgb("#011A27"));
		 pAddress.setBackground(hex2Rgb("#011A27"));
 		 panel.setBackground(hex2Rgb("#011A27"));
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

	static Account fillAccountInfo(String username){
		Account currentUser = new Account(username, Account.parseJSON(Account.getAccount(username), 0, "firstName"),Account.parseJSON(Account.getAccount(username), 0, "lastName"), Account.parseJSON(Account.getAccount(username), 0, "password"),Integer.parseInt(Account.parseJSON(Account.getAccount(username), 0, "age").trim()));
		
		
		return currentUser;
	}
	static Bio fillBioInfo(String username){
		Bio currentBio = new Bio(currentUser.getId());
		currentBio.setCompletedJobs(Integer.parseInt(Account.parseJSON(Account.getAccount(username), 1, "completedJobs").trim())+1);
		currentBio.setDescription(Account.parseJSON(Account.getAccount(username), 1, "description").trim());
		currentBio.setHoursWorked(Integer.parseInt(Account.parseJSON(Account.getAccount(username), 1, "hoursWorked").trim()));
		currentBio.setPhoneNumber(Account.parseJSON(Account.getAccount(username), 1, "phoneNumber").trim());
	return currentBio;
	}
	static Task[] fillTasks(){
		
		
		return null;
	}

	
}


