import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;


public class Trackusers {

	private static JFrame fraUsers;
	public JFrame getJFrame(){
		return fraUsers;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trackusers window = new Trackusers();
					window.fraUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Trackusers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fraUsers = new JFrame();
		fraUsers.setBounds(100, 100, 450, 300);
		fraUsers.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fraUsers.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("You can track how many user do we have at here");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblTitle.setBounds(10, 11, 435, 47);
		fraUsers.getContentPane().add(lblTitle);
		
		JLabel lbldetial = new JLabel("...");
		lbldetial.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lbldetial.setBounds(10, 113, 435, 47);
		fraUsers.getContentPane().add(lbldetial);
		
		JButton btntotal = new JButton("Total Users");
		btntotal.setForeground(hex2Rgb("#011A27"));
		btntotal.setBackground(hex2Rgb("#F0810F"));
		btntotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = "Users.txt";
				String line=null;
				
				String[] Usersid = new String[10000];
				int totalusers=0;
				
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int i=0; i<10000;i++ )  
				     {
				      
				    	   Usersid[i]=line;
				    	   line =in.readLine();
				    	   if (line==null) {
				    		   totalusers = i + 1;
				    		   i=i+10000;
				    	   }
				    	
				       
				     }
				     in.close();
				   }
				   catch ( IOException iox )
				   {
				     System.out.println("Problem reading " + fileName );
				   }
				
				 
				
				lbldetial.setText("We already have "+totalusers + " users :)");
				
				
			}
		});
		btntotal.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btntotal.setBounds(10, 69, 98, 29);
		fraUsers.getContentPane().add(btntotal);
		
		JButton btnyears = new JButton("Per Years");
		btnyears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Users.txt";
				String line=null;
				
				String[] Usersid = new String[10000];
				int totalusers=0;
				
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int i=0; i<10000;i++ )  
				     {
				      
				    	   Usersid[i]=line;
				    	   line =in.readLine();
				    	   if (line==null) {
				    		   totalusers = i + 1;
				    		   i=i+10000;
				    	   }
				    	
				       
				     }
				     in.close();
				   }
				   catch ( IOException iox )
				   {
				     System.out.println("Problem reading " + fileName );
				   }
				
				 
				
				lbldetial.setText("We  have "+totalusers + " more users this Year:)");
			}
		});
		btnyears.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnyears.setBounds(118, 69, 103, 29);
		btnyears.setForeground(hex2Rgb("#011A27"));
		btnyears.setBackground(hex2Rgb("#F0810F"));
		fraUsers.getContentPane().add(btnyears);
		
		JButton btnPerMonths = new JButton("Per Months");
		btnPerMonths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Users.txt";
				String line=null;
				
				String[] Usersid = new String[10000];
				int totalusers=0;
				
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int i=0; i<10000;i++ )  
				     {
				      
				    	   Usersid[i]=line;
				    	   line =in.readLine();
				    	   if (line==null) {
				    		   totalusers = i + 1;
				    		   i=i+10000;
				    	   }
				    	
				       
				     }
				     in.close();
				   }
				   catch ( IOException iox )
				   {
				     System.out.println("Problem reading " + fileName );
				   }
				
				 
				
				lbldetial.setText("We  have "+totalusers + " more users this Month:)");
			}
		});
		btnPerMonths.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnPerMonths.setBounds(226, 69, 103, 29);
		btnPerMonths.setForeground(hex2Rgb("#011A27"));
		btnPerMonths.setBackground(hex2Rgb("#F0810F"));
		fraUsers.getContentPane().add(btnPerMonths);
		
		JButton btnPerWeeks = new JButton("Per Weeks");
		btnPerWeeks.setForeground(hex2Rgb("#011A27"));
		btnPerWeeks.setBackground(hex2Rgb("#F0810F"));
		btnPerWeeks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Users.txt";
				String line=null;
				
				String[] Usersid = new String[10000];
				int totalusers=0;
				
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int i=0; i<10000;i++ )  
				     {
				      
				    	   Usersid[i]=line;
				    	   line =in.readLine();
				    	   if (line==null) {
				    		   totalusers = i + 1;
				    		   i=i+10000;
				    	   }
				    	
				       
				     }
				     in.close();
				   }
				   catch ( IOException iox )
				   {
				     System.out.println("Problem reading " + fileName );
				   }
				
				 
				
				lbldetial.setText("We  have "+totalusers + " more users this Weaks:)");
			}
		});
		btnPerWeeks.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnPerWeeks.setBounds(321, 69, 103, 29);
		fraUsers.getContentPane().add(btnPerWeeks);
		
	
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
	
}
