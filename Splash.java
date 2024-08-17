package Dairy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.border.BevelBorder;

public class Splash extends JFrame {

	private JPanel contentPane;
	static JProgressBar progressBar;
	Details d = new Details();
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Splash frame = new Splash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					frame.setVisible(true);
					  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		File f = new File(System.getProperty("user.home")+"\\Dairy_details");
		if(f.exists())
		{
			FileReader file = new FileReader(System.getProperty("user.home")+"\\Dairy_details");
			BufferedReader br = new BufferedReader(file);
			frame.d.name = br.readLine(); 
			frame.d.imgPath = br.readLine();
			frame.d.filePath = br.readLine();
			frame.d.start_date=br.readLine();
			 new Dairy(frame.d).setVisible(true);
			 frame.dispose();
			 
		}else
		{
			new Login().setVisible(true);
			frame.dispose();
		}
 }
	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public Splash()  {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    progressBar = new JProgressBar();
		progressBar.setBounds(0, 461, 775, 22);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("DairyImage.jpg")); 
		lblNewLabel.setBounds(0, 0, 775, 461);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		
	}
}
