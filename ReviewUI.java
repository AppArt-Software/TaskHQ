package UI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class ReviewUI {
	//JFrame container of the review panel
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewUI window = new ReviewUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public ReviewUI() throws IOException {
		initialize();
	}

	/**
	 * Author: Christian Dresser
	 * Initialize the contents of the frame.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//width of the panel
		int WIDTH = 500;
		//height of the panel
		int HEIGHT = 750;
		//all JPanels used in the review UI
		JPanel mainPanel, topPane, middlePane, bottomPane, textPane;
		//all JLabels used in the review UI
		JLabel imgLabel, nameLabel, starLabel1, starLabel2, starLabel3, starLabel4, starLabel5, reviewLabel;
		JLabel[] starLabels;
		//JTextArea to write the review
		JTextArea review;
		//JButton to submit the review
		JButton submit;
		
		//GBC necessary for grid bag layout
		GridBagConstraints gbc = new GridBagConstraints();
		//full star image for rating
		BufferedImage fullStar = ImageIO.read(getClass().getResource("/fullstar.jpg"));
		//resized version of fullstar
		BufferedImage resizedFullStar; //resizeImage(fullStar, 50, 50, true);
		
		//code section to resize the fullstar image
		//resizeImage() {
		int starType = (fullStar.getTransparency() == Transparency.OPAQUE)
		        ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage starBi = new BufferedImage(50, 50, starType);
		Graphics2D graphics1 = starBi.createGraphics();
		graphics1.drawImage(fullStar, 0, 0, 50, 50, null);
		graphics1.dispose();
		resizedFullStar = starBi;
		//}

		//image used as template profile picture
		BufferedImage profile = ImageIO.read(getClass().getResource("/profile.jpg"));
		//masked version of profile image (circle mask)
		BufferedImage maskedProfile;
		
		//code section to mask image
		//maskImg(){
	    int diameter = Math.min(profile.getWidth(), profile.getHeight());
	    BufferedImage mask = new BufferedImage(profile.getWidth(), profile.getHeight(), BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = mask.createGraphics();
	   // applyQualityRenderingHints(g2d);
	    g2d.fillOval(0, 0, diameter - 1, diameter - 1);
	    g2d.dispose();

	    BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
	    g2d = masked.createGraphics();
	   // applyQualityRenderingHints(g2d);
	    int x = (diameter - profile.getWidth()) / 2;
	    int y = (diameter - profile.getHeight()) / 2;
	    g2d.drawImage(profile, x, y, null);
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
	    g2d.drawImage(mask, 0, 0, null);
	    g2d.dispose();
		
		maskedProfile = masked;
		
		//}
		
		//resized version of the profile image
		BufferedImage resizedProfile; // = resizeImage(masked, 100, 100, true);
		
		//code section to resize image
		//resizeImage() {
		int type = (maskedProfile.getTransparency() == Transparency.OPAQUE)
		        ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage bi = new BufferedImage(100, 100, type);
		Graphics2D graphics2 = bi.createGraphics();
		graphics2.drawImage(maskedProfile, 0, 0, 100, 100, null);
		graphics2.dispose();
		
		resizedProfile = bi;
		//}
		
		//panel that will hold every other panel for the UI
		JPanel panel = new JPanel();
		
		//code section to close window when the escape key is pressed
		   KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		    AbstractAction escapeAction = new AbstractAction() {
		      public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		      }
		    };
		    panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        escapeKeyStroke, "ESCAPE");
		    panel.getActionMap().put("ESCAPE", escapeAction);
		
		    panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(255, 140, 0)));
		    panel.setSize(WIDTH, HEIGHT);
		
		//initialization of all JPanels used in the UI
		mainPanel = new JPanel();
		topPane = new JPanel();
		middlePane = new JPanel();
		bottomPane = new JPanel();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		//code section to generate the top pane (profile picture and name)
		//genTopPane() {
		
		topPane.setLayout(new BoxLayout(topPane, BoxLayout.Y_AXIS));
		imgLabel = new JLabel();
		nameLabel = new JLabel("FIRSTNAME LASTNAME");
		
		nameLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
		

		imgLabel.setIcon(new ImageIcon(resizedProfile));
		imgLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
		
		imgLabel.addMouseListener(new MouseAdapter() {
			//show large version of profile picture when it is clicked
			@Override
			public void mouseClicked(MouseEvent me) {
				
				if(me.getSource() == imgLabel) {
					JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(masked)));
				}

			}
			
			});
		
		topPane.add(Box.createRigidArea(new Dimension(0, 65)));
		topPane.add(imgLabel);
		topPane.add(Box.createRigidArea(new Dimension(0, 20)));
		topPane.add(nameLabel);
		topPane.add(Box.createRigidArea(new Dimension(0, 60)));
		
		//}
		
		//code section to generate the middle panel (stars)
		//genMiddlePane() {
		
		middlePane.setLayout(new BoxLayout(middlePane, BoxLayout.LINE_AXIS));
		starLabels = new JLabel[5];
		starLabel1 = new JLabel();
		starLabel2 = new JLabel();
		starLabel3 = new JLabel();
		starLabel4 = new JLabel();
		starLabel5 = new JLabel();
		
		BufferedImage emptyStar = ImageIO.read(getClass().getResource("/emptystar.jpg"));
		BufferedImage resizedEmptyStar;//resizeImage(emptyStar, 50, 50, true);
		
		//resizeImage() {
		  int emptyType = (emptyStar.getTransparency() == Transparency.OPAQUE)
		          ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		  BufferedImage emptyBi = new BufferedImage(50, 50, emptyType);
		  Graphics2D graphics = emptyBi.createGraphics();
		  graphics.drawImage(emptyStar, 0, 0, 50, 50, null);
		  graphics.dispose();
		  
		  resizedEmptyStar = emptyBi;
		//}
		
		starLabel1.setIcon(new ImageIcon(resizedEmptyStar));
		starLabel2.setIcon(new ImageIcon(resizedEmptyStar));
		starLabel3.setIcon(new ImageIcon(resizedEmptyStar));
		starLabel4.setIcon(new ImageIcon(resizedEmptyStar));
		starLabel5.setIcon(new ImageIcon(resizedEmptyStar));
				
		starLabel1.setAlignmentY(Box.CENTER_ALIGNMENT);
		starLabel2.setAlignmentY(Box.CENTER_ALIGNMENT);
		starLabel3.setAlignmentY(Box.CENTER_ALIGNMENT);
		starLabel4.setAlignmentY(Box.CENTER_ALIGNMENT);
		starLabel5.setAlignmentY(Box.CENTER_ALIGNMENT);
		
		//mouse listeners allow for stars to be clicked (and rate user a number of stars)
		starLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
					starLabel1.setIcon(new ImageIcon(resizedFullStar));
				}
			});
		starLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
					starLabel2.setIcon(new ImageIcon(resizedFullStar));
					starLabel1.setIcon(new ImageIcon(resizedFullStar));
				}
			});
		starLabel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
					starLabel1.setIcon(new ImageIcon(resizedFullStar));
					starLabel2.setIcon(new ImageIcon(resizedFullStar));
					starLabel3.setIcon(new ImageIcon(resizedFullStar));
				}
			});
		starLabel4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
					starLabel1.setIcon(new ImageIcon(resizedFullStar));
					starLabel2.setIcon(new ImageIcon(resizedFullStar));
					starLabel3.setIcon(new ImageIcon(resizedFullStar));
					starLabel4.setIcon(new ImageIcon(resizedFullStar));
				}
			});
		starLabel5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
					starLabel1.setIcon(new ImageIcon(resizedFullStar));
					starLabel2.setIcon(new ImageIcon(resizedFullStar));
					starLabel3.setIcon(new ImageIcon(resizedFullStar));
					starLabel4.setIcon(new ImageIcon(resizedFullStar));
					starLabel5.setIcon(new ImageIcon(resizedFullStar));
				}
			});
		
		middlePane.add(Box.createRigidArea(new Dimension(20,0)));
		middlePane.add(starLabel1);
		middlePane.add(Box.createRigidArea(new Dimension(10,0)));
		middlePane.add(starLabel2);
		middlePane.add(Box.createRigidArea(new Dimension(10,0)));
		middlePane.add(starLabel3);
		middlePane.add(Box.createRigidArea(new Dimension(10,0)));
		middlePane.add(starLabel4);
		middlePane.add(Box.createRigidArea(new Dimension(10,0)));
		middlePane.add(starLabel5);
		middlePane.add(Box.createRigidArea(new Dimension(20,0)));	
		
		//}
		
		
		//code section of generate the bottom panel (prompt, text area, and submit button)
		//genBottomPane() {
		
		bottomPane.setLayout(new GridBagLayout());
		
		reviewLabel = new JLabel("Enter Your Review: ");
		
		gbc.insets = new Insets(10, 0, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;

		bottomPane.add(reviewLabel, gbc);
		
		review = new JTextArea(10, 40);
		
		gbc.insets = new Insets(0, 10, 0, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.ipady = 50;
		
		bottomPane.add(review, gbc);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Comfortaa", Font.PLAIN, 20));
		submit.setBorder(new LineBorder(Color.black, 8, true));
		submit.setOpaque(true);
		submit.setBackground(new Color(240,129,15)); 
		submit.setPreferredSize(new Dimension(100, 50));
		
		submit.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,
					    "Review added!",
					    "Thanks!",
					    JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
			}
		});
		
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		
		bottomPane.add(submit, gbc);
		
		//}
		mainPanel.add(topPane);
		mainPanel.add(middlePane);
		mainPanel.add(bottomPane);
		
		panel.add(mainPanel);
		panel.setVisible(true);
		
		frame.add(panel);

	}

}
