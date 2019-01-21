import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Analytics {

	private JFrame fraAnalytics;
	private JFrame fraUsers;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analytics window = new Analytics();
					window.fraAnalytics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Analytics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fraAnalytics = new JFrame();
		fraAnalytics.setBounds(100, 100, 450, 300);
		fraAnalytics.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fraAnalytics.getContentPane().setLayout(null);
		
		
		JLabel lblTitle = new JLabel("You can track our data at here");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblTitle.setBounds(49, 11, 344, 47);
		fraAnalytics.getContentPane().add(lblTitle);
		
		JButton btnusers = new JButton("Track Users");
		btnusers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Trackusers trackusers = new Trackusers();
				trackusers.getJFrame().setVisible(true);
				
			
			}
		});
		btnusers.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnusers.setBounds(20, 90, 175, 56);
		btnusers.setForeground(hex2Rgb("#011A27"));
		btnusers.setBackground(hex2Rgb("#F0810F"));
		fraAnalytics.getContentPane().add(btnusers);
		
		JButton btnjobs = new JButton("Track Jobs");
		btnjobs.setForeground(hex2Rgb("#011A27"));
		btnjobs.setBackground(hex2Rgb("#F0810F"));
		btnjobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Trackjobs trackjobs = new Trackjobs();
				trackjobs.getJFrame().setVisible(true);
				
			}
		});
		btnjobs.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnjobs.setBounds(218, 90, 175, 56);
		fraAnalytics.getContentPane().add(btnjobs);
		
		JButton btnReviews = new JButton("Track Reviews");
		btnReviews.setForeground(hex2Rgb("#011A27"));
		btnReviews.setBackground(hex2Rgb("#F0810F"));
		btnReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Trackreviews trackreviews = new Trackreviews();
				trackreviews.getJFrame().setVisible(true);
				
			}
		});
		btnReviews.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnReviews.setBounds(122, 176, 175, 56);
		fraAnalytics.getContentPane().add(btnReviews);
		
		
	}
	public static Color hex2Rgb(String colorStr) {
	    return new Color(
	            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
	            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
	            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}
}
