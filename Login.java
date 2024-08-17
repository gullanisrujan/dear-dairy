package Dairy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField imagePath;
	private JTextField dairyPath;
	static Login frame=null;
	 Details details = new Details();
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
//				    frame = new Login();
//					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
 	
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 26));
		lblNewLabel.setToolTipText(" ");
		lblNewLabel.setBounds(309, 44, 189, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Myanmar Text", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(71, 139, 130, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Image");
		lblNewLabel_2.setFont(new Font("Myanmar Text", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 204, 130, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Save your dairy at");
		lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(71, 277, 130, 31);
		contentPane.add(lblNewLabel_3);
		
		JButton submit = new JButton("Next");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime dat = LocalDateTime.now();
			    details.name=name.getText();
				details.imgPath=imagePath.getText();
				details.filePath=dairyPath.getText();
				details.start_date=dat.format(DateTimeFormatter.ofPattern("MMM-yyyy-dd"));
			    FileWriter f = null;
				try {
					f = new FileWriter(System.getProperty("user.home")+"\\Dairy_details");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    try {
					f.write(""+details.name+"\n"+details.imgPath+"\n"+details.filePath+"\n"+details.start_date);
					f.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    File file=new File(details.filePath+"\\Dairy");
			    file.mkdir();
			     
			    try {
					new Dairy(details).setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    frame.dispose();
			}
		});
		submit.setBackground(Color.GREEN);
		submit.setForeground(Color.RED);
		submit.setBounds(311, 342, 124, 31);
		contentPane.add(submit);
		
		name = new JTextField();
		name.setForeground(Color.BLACK);
		name.setBackground(new Color(255, 255, 255));
		name.setBounds(239, 131, 291, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		imagePath = new JTextField();
		imagePath.setBounds(239, 195, 291, 31);
		contentPane.add(imagePath);
		imagePath.setColumns(10);
		
		dairyPath = new JTextField();
		dairyPath.setBounds(239, 271, 291, 31);
		contentPane.add(dairyPath);
		dairyPath.setColumns(10);
		
		JButton ingpathbtn = new JButton("Browse");
		ingpathbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser=new JFileChooser(); 
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				imagePath.setText(f.getAbsolutePath());
				 
			}
		});
		ingpathbtn.setBackground(Color.LIGHT_GRAY);
		ingpathbtn.setBounds(584, 200, 85, 21);
		contentPane.add(ingpathbtn);
		
		JButton filepathbtn = new JButton("Browse");
		filepathbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser=new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				dairyPath.setText(f.getAbsolutePath());
				
			}
		});
		filepathbtn.setBackground(Color.LIGHT_GRAY);
		filepathbtn.setBounds(584, 271, 85, 21);
		contentPane.add(filepathbtn);
		
		setLocationRelativeTo(null);
		getContent();
		
	}
	
	public void getContent()
	{
//		te
	}
	
}
 