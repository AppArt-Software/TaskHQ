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

public class Trackreviews {

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
					Trackreviews window = new Trackreviews();
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
	public Trackreviews() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouCanTrack = new JLabel("You can track how many reviews do we have at here");
		lblYouCanTrack.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblYouCanTrack.setBounds(15, 15, 435, 47);
		frame.getContentPane().add(lblYouCanTrack);
		
		JLabel lbldetial = new JLabel("...");
		lbldetial.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lbldetial.setBounds(15, 121, 435, 47);
		frame.getContentPane().add(lbldetial);
		
		JButton btnTotalReviews = new JButton("Total Reviews");
		btnTotalReviews.setForeground(hex2Rgb("#011A27"));
		btnTotalReviews.setBackground(hex2Rgb("#F0810F"));
		btnTotalReviews.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				String fileName = "Reviews.txt";
			String line=null;
			String[][] Reviews = new String[10000][5];
			int totalReviews=0;
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int r=0; r<10000;r++ )  
				     {
				    	
				       for(int c=0; c<5;c++ )
				       {
				    	  Reviews[r][c]=line;
				    	   line =in.readLine(); 
				    	   if (line==null) {
				    		 totalReviews += r+1  ;
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
				
				lbldetial.setText("We  already have "+totalReviews + " reviews:)");
				
				
				
				
				
			}
		});
		btnTotalReviews.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		btnTotalReviews.setBounds(15, 77, 98, 29);
		frame.getContentPane().add(btnTotalReviews);
		
		JButton button_1 = new JButton("Per Years");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fileName = "Reviews.txt";
			String line=null;
			String[][] Reviews = new String[10000][5];
			int totalReviews=0;
				try
				   {      
					 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
				     line =in.readLine();
				     
				     for (int r=0; r<10000;r++ )  
				     {
				    	
				       for(int c=0; c<5;c++ )
				       {
				    	  Reviews[r][c]=line;
				    	   line =in.readLine(); 
				    	   if (line==null) {
				    		 totalReviews += r+1  ;
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
				
				lbldetial.setText("We have "+totalReviews + " more reviews this Year:)");
				
				
				
				
				
			
			}
		});
		button_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		button_1.setBounds(123, 77, 103, 29);
		button_1.setForeground(hex2Rgb("#011A27"));
		button_1.setBackground(hex2Rgb("#F0810F"));
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Per Months");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "Reviews.txt";
				String line=null;
				String[][] Reviews = new String[10000][5];
				int totalReviews=0;
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<5;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalReviews += r+1  ;
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
					
					lbldetial.setText("We have "+totalReviews + " more reviews this Month:)");
					
					
					
					
					
				
			}
		});
		button_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		button_2.setBounds(231, 77, 103, 29);
		button_2.setForeground(hex2Rgb("#011A27"));
		button_2.setBackground(hex2Rgb("#F0810F"));
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Per Weeks");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fileName = "Reviews.txt";
				String line=null;
				String[][] Reviews = new String[10000][5];
				int totalReviews=0;
					try
					   {      
						 BufferedReader in= new BufferedReader( new FileReader( fileName  ) );
					     line =in.readLine();
					     
					     for (int r=0; r<10000;r++ )  
					     {
					    	
					       for(int c=0; c<5;c++ )
					       {
					    	  Reviews[r][c]=line;
					    	   line =in.readLine(); 
					    	   if (line==null) {
					    		 totalReviews += r+1  ;
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
					
					lbldetial.setText("We have "+totalReviews + " more reviews this Week:)");
					
					
					
					
					
				
			}
		});
		button_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 15));
		button_3.setBounds(326, 77, 103, 29);
		button_3.setForeground(hex2Rgb("#011A27"));
		button_3.setBackground(hex2Rgb("#F0810F"));
		frame.getContentPane().add(button_3);
		
	
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}

}
