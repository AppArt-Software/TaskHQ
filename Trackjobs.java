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
import java.awt.event.ActionEvent;

public class Trackjobs {

	private static JFrame frame;
	public JFrame getJFrame(){
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trackjobs window = new Trackjobs();
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
	public Trackjobs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouCanTrack = new JLabel("You can track how many jobs do we have at here");
		lblYouCanTrack.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblYouCanTrack.setBounds(15, 15, 435, 47);
		frame.getContentPane().add(lblYouCanTrack);
			JLabel lbldetail = new JLabel("...");
		lbldetail.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lbldetail.setBounds(0, 121, 911, 90);
		frame.getContentPane().add(lbldetail);
		
		JButton btnTotalJobs = new JButton("Total Jobs");
		btnTotalJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = "Jobs.txt";
				String line=null;
				String[][] Reviews = new String[10000][6];
				int totalJobs=0;
				
				 {
					
					
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<6;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalJobs += r+1  ;
					    		   r=r+10000;
					    	   }
					    	
					       }
					     }
					     in.close();
					   }
					   catch ( IOException iox )
					   {
					     System.out.println("Problem reading " + fileName );
					   }
					
					lbldetail.setText("We already have "+totalJobs + " jobs:)");
					
					
					
					
					
				}
			}
		});
		btnTotalJobs.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnTotalJobs.setForeground(hex2Rgb("#011A27"));
		btnTotalJobs.setBackground(hex2Rgb("#F0810F"));
		btnTotalJobs.setBounds(0, 77, 98, 29);
		frame.getContentPane().add(btnTotalJobs);
		
		JButton button_1 = new JButton("Per Years");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Jobs.txt";
				String line=null;
				String[][] Reviews = new String[10000][6];
				int totalJobs=0;
				
				 {
					
					
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<6;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalJobs += r+1  ;
					    		   r=r+10000;
					    	   }
					    	
					       }
					     }
					     in.close();
					   }
					   catch ( IOException iox )
					   {
					     System.out.println("Problem reading " + fileName );
					   }
					
					lbldetail.setText("We have "+totalJobs + " more jobs this year:)");
			}
			}});
		button_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		button_1.setBounds(108, 77, 103, 29);
		button_1.setForeground(hex2Rgb("#011A27"));
		button_1.setBackground(hex2Rgb("#F0810F"));
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Per Months");
		button_2.setForeground(hex2Rgb("#011A27"));
		button_2.setBackground(hex2Rgb("#F0810F"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String fileName = "Jobs.txt";
				String line=null;
				String[][] Reviews = new String[10000][6];
				int totalJobs=0;
				
				 {
					
					
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<6;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalJobs += r+1  ;
					    		   r=r+10000;
					    	   }
					    	
					       }
					     }
					     in.close();
					   }
					   catch ( IOException iox )
					   {
					     System.out.println("Problem reading " + fileName );
					   }
					
					lbldetail.setText("We have "+totalJobs + " more jobs this month:)");
			}
			}
		});
		button_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		button_2.setBounds(216, 77, 103, 29);
		frame.getContentPane().add(button_2);
		
		JButton btnBestPayment = new JButton("Best Payment");
		btnBestPayment.setForeground(hex2Rgb("#011A27"));
		btnBestPayment.setBackground(hex2Rgb("#F0810F"));
		btnBestPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Jobs.txt";
				String line=null;
				String[][] Reviews = new String[10000][6];
				int totalJobs=0;
				
				 {
					
					
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<6;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalJobs += r+1  ;
					    		   r=r+10000;
					    	   }
					    	
					       }
					     }
					     in.close();
					   }
					   catch ( IOException iox )
					   {
					     System.out.println("Problem reading " + fileName );
					   }
					
					int bestpayment = 0;
					int x=0;
					for(int i=0; i< totalJobs; i++) {
						if(bestpayment < Integer.parseInt(Reviews[i][2])) {
							bestpayment = Integer.parseInt(Reviews[i][2]);
							x = i;
						}
					}
					
					
					
					lbldetail.setText("The best payment job is "+Reviews[x][0] +" "+Reviews[x][5] + " on " + Reviews[x][4] + " can earn " + Reviews[x][2] + " each hour");
			}
				
				
			}
		});
		btnBestPayment.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnBestPayment.setBounds(322, 77, 103, 29);
		frame.getContentPane().add(btnBestPayment);
		

	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}
