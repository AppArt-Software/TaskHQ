package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;

import baseClasses.Account;
import baseClasses.Task;

public class CalendarUI {

	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarUI window = new CalendarUI(null, null,null,null,null,null,null,null,null,null,null);
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
	public CalendarUI(Account currentUser, String[] id, String[] title, String[] employer, String[] location, String[] start, String[] end, String[] skills, String[] description,
			String[] posted, String[] completed) {
		initialize(currentUser, id, title, employer, location, start, end, skills, description, posted, completed);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Account currentUser, String[] id, String[] title, String[] employer, String[] location, String[] start, 
			String[] end, String[] skills, String[] description, String[] posted, String[] completed) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton approve = new JButton("Approve Task");
		JLabel Jposted = new JLabel();
		JLabel approved = new JLabel();
		
		
		String[] dayNames = { "S", "M", "T", "W", "T", "F", "S" };
			JPanel dayPanel = new  JPanel();
		    dayPanel.setLayout(new GridLayout(0,7));

		    Calendar calendar = Calendar.getInstance();
		    calendar.set(Calendar.MONTH, 0);    // set month
		    calendar.set(Calendar.YEAR, 2019);
		    calendar.set(Calendar.DAY_OF_MONTH, 1);

		    Calendar iterator = (Calendar) calendar.clone();
		    iterator.add(Calendar.DAY_OF_MONTH,
		        -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

		    Calendar maximum = (Calendar) calendar.clone();
		    maximum.add(Calendar.MONTH, +1);
		    
		    
		    for (int i = 0; i < 7; i++) {
		      JPanel dPanel = new JPanel(true);
		      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		      JLabel dLabel = new JLabel(dayNames[i]);//dayNames[i]
		      dLabel.setForeground(hex2Rgb("#F0810F"));
		      dPanel.add(dLabel);
		      dayPanel.add(dPanel);
		    }

		    int count = 0;
		    int limit = 7 * 6;

		    while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
		      int lMonth = iterator.get(Calendar.MONTH);
		      int lYear = iterator.get(Calendar.YEAR);
		      final int lday =iterator.get(Calendar.DAY_OF_MONTH);

		      final JPanel dPanel = new  JPanel();
		      dPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		      dPanel.setLayout(new BoxLayout(dPanel, BoxLayout.Y_AXIS));
		      JLabel dayLabel = new JLabel();
		      JLabel shift = new JLabel();
		      shift.setAlignmentX(Component.CENTER_ALIGNMENT);
		      shift.setLayout(new BoxLayout(shift, BoxLayout.Y_AXIS));
		      shift.setFont(new Font("Comfortaa", Font.PLAIN, 13));
		      shift.setForeground(hex2Rgb("#F0810F"));
		      JButton moreinfo = new JButton("More Info");
		      moreinfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		      moreinfo.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		      moreinfo.setBorder(new LineBorder(Color.black, 2, true));
		      moreinfo.setOpaque(true);
		      moreinfo.setBackground(hex2Rgb("#F0810F"));
		      approve.setAlignmentX(Component.CENTER_ALIGNMENT);
		      approve.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		      approve.setBorder(new LineBorder(Color.black, 2, true));
		      approve.setOpaque(true);
		      approve.setBackground(hex2Rgb("#F0810F"));
		      JButton reviewtask = new JButton("Review Task");
		      reviewtask.setAlignmentX(Component.CENTER_ALIGNMENT);
		      reviewtask.setFont(new Font("Comfortaa", Font.PLAIN, 15));
		      reviewtask.setBorder(new LineBorder(Color.black, 2, true));
		      reviewtask.setOpaque(true);
		      reviewtask.setBackground(hex2Rgb("#F0810F"));
		      approved.setAlignmentX(Component.CENTER_ALIGNMENT);
		      Jposted.setAlignmentX(Component.CENTER_ALIGNMENT);
		      Jposted.setText("You posted this shift");

		      if ((lMonth == 0) && (lYear == 2019)) { //check correct month and year
		        int lDay = iterator.get(Calendar.DAY_OF_MONTH);
		        dayLabel.setText("  " +Integer.toString(lDay)); 
		      } 
		      dPanel.add(dayLabel);
		      dPanel.add(shift);
		      dayPanel.add(dPanel);
		      iterator.add(Calendar.DAY_OF_YEAR, +1);
		      count++;
		      
		      for (int i = 0; i < id.length; i++) {
		    	  String startDate = start[i];
		    	  
		    	  String[] parts = startDate.split("-");
		    	  
		    	  int month = Integer.parseInt(parts[1]);
		    	  String strDay = parts[2].substring(0,2);
		    	  int day = Integer.parseInt(strDay);
		    	  System.out.println(employer[i]);
		    	  if (month-1 == Calendar.getInstance().get(Calendar.MONTH)) {
		    		  if (lday == day) {
		    			  if (employer[i].equals(currentUser.getFirstName() + " " + currentUser.getLastName())) {
		    		    	  shift.setText(title[i]);
		    		    	  if (posted[i] == "1") {
		    		    		  dPanel.add(Jposted);
		    		    	  } else if (completed[i] == "1") {
		    				      dPanel.add(reviewtask);
		    				      dPanel.add(moreinfo);

		    		    	  } else {
		    		    	  dPanel.add(approve);
		    		    	  dPanel.add(approved);
		    		    	  dPanel.add(moreinfo);
		    		    	  }
		    			  } else {
		    				  shift.setText(title[i]);
		    		    	  dPanel.add(moreinfo);
		    			  }
	    				   
    				      int x = i;
	    				  	moreinfo.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
	    			    		dPanel.setBackground(new Color(232,232,232));
	    				    			new TaskInfoUI(employer[x],location[x],start[x],end[x],skills[x],description[x]);
	    						    }});
	    				  	
	    				      approve.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
	    				    	  dPanel.setBackground(new Color(232,232,232));
	    				    	  if (approve.getText().toString().equals("Task Complete")) {
	    				    	 		Task.updateTaskStatus(Integer.parseInt(id[x]),false, false, false, true);
		    				    		approve.setVisible(false);
		    				  	      	dPanel.add(reviewtask);
		    							//custom title, error icon
		    							JOptionPane.showMessageDialog(frame,
		    							    "You have confirmed that someone has completed the job! You can now write a review"
		    							    + " about them if you wish.",
		    							    "Congrats!",
		    							    JOptionPane.INFORMATION_MESSAGE);
	    				    	  } else {
	    				    		Task.updateTaskStatus(Integer.parseInt(id[x]),false, false, true, false);
	    				    		approve.setText("Task Complete");
	    							//custom title, error icon
	    							JOptionPane.showMessageDialog(frame,
	    							    "You have approved that someone has picked up your shift! Once they've completed the task,"
	    							    + " press 'Task Complete' to verify they've completed the job!",
	    							    "Congrats!",
	    							    JOptionPane.INFORMATION_MESSAGE);
	    				    	  }
	    				      }});
		    		  }
		    	  }
		      }
		      
		    
		    	
		    	

		      
		      reviewtask.addActionListener( new ActionListener() {public void actionPerformed(ActionEvent e) { 
	    			dPanel.setBackground(new Color(232,232,232));
	    			//a pop up for the review panel would be here
				    }});
		      
		      dayPanel.addMouseListener(new MouseAdapter(){
				    @Override
				    public void mouseClicked(MouseEvent e) {
				    	dPanel.setBackground(Color.white); }
				    }); 
		    }

		    for (int i = count; i < limit-7; i++) {
		      JPanel pPanel = new JPanel(true);
		      pPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		      pPanel.add(new JLabel());
		      dayPanel.add(pPanel);
		    }

		    frame.getContentPane().add(dayPanel);
		    
		    frame.setVisible(true);
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
