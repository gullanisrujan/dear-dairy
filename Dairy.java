package Dairy;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Insets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Dairy extends JFrame {
	private JPanel contentPane;
	JTextArea textArea=null;
	JLabel page=null;
	private final JPanel panel = new JPanel();
    Calendar cal =Calendar.getInstance(); 
    SimpleDateFormat sf = new SimpleDateFormat("MMM-yyyy-dd"); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						Dairy frame = new Dairy(new Details());
						frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Dairy(Details d) throws Exception {
		
		 
		
		LocalDateTime dat = LocalDateTime.now();
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("E , MMM dd yyyy");
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH : mm : ss");
		setResizable(false);
		setTitle("Dairy"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361,800);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 230, 740);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(d.imgPath));
		lblNewLabel.setBounds(10, 10, 210, 223);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name : ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(86, 268, 87, 26);
		panel.add(lblNewLabel_1);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setForeground(Color.RED);
		nameLabel.setText(d.name);
		nameLabel.setBounds(10, 327, 210, 35);
		panel.add(nameLabel);
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(86, 403, 87, 26);
		panel.add(lblNewLabel_2);
		
		JLabel dateLabel = new JLabel("");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setText(dat.format(format1));
		dateLabel.setForeground(Color.RED);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateLabel.setBounds(10, 456, 210, 35);
		panel.add(dateLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Time :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(86, 521, 106, 26);
		panel.add(lblNewLabel_3);
		
		JLabel tineLabel = new JLabel("");
		tineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tineLabel.setText(dat.format(format2));
		tineLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tineLabel.setForeground(Color.RED);
		tineLabel.setBounds(10, 576, 210, 35);
		panel.add(tineLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(293, 35, 999, 715);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 999, 763);
		panel_1.add(scrollPane);
		
        textArea = new JTextArea();
		textArea.setMargin(new  Insets(20,20,20,20));
		textArea.setFont(new Font("Comic SansMS",Font.BOLD,18));
		textArea.setAlignmentX(1.0f);
		textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textArea.setLineWrap(true);
		 
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		File f=new File(d.filePath+"Dairy\\"+dat.format(DateTimeFormatter.ofPattern("MMM-yyyy-dd"))+".txt");
		if(f.exists())
		{
			FileReader fr = new FileReader(f.getAbsoluteFile());
			int i; StringBuilder sb = new StringBuilder();
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			textArea.setText(sb.toString()); 
			fr.close();
		}
		else
		{
		  f.createNewFile();
		}
		
		
		JButton prev = new JButton("");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.out.println(sf.format(cal.getTime()));  System.out.println(d.start_date);
				if((sf.format(cal.getTime())).equals(d.start_date))
				{
					return;
				}
				cal.add(cal.DATE,-1);
				if(new File(d.filePath+"Dairy\\"+sf.format(cal.getTime())+".txt").exists()) 
				{
			        try {
						extractFrom(d.filePath+"Dairy\\"+sf.format(cal.getTime())+".txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	 
		    	}
		    	else
		    	{
		    			prev.doClick();
		    	}
			}});
		prev.setBackground(new Color(240, 240, 240));
		prev.setFont(new Font("Arial", Font.BOLD, 18));
		prev.setBounds(250, 337, 33, 115);
		contentPane.add(prev);
		
		JButton savebtn = new JButton("Save");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					 
				    File file = new File(d.filePath+"Dairy\\"+sf.format(cal.getTime())+".txt");   
					FileWriter f = new FileWriter(file.getAbsoluteFile());
					f.write(textArea.getText());
					f.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		savebtn.setBackground(Color.GREEN);
		savebtn.setFont(new Font("Georgia", Font.BOLD, 18));
		savebtn.setBounds(294, 10, 102, 25);
		contentPane.add(savebtn);
		
		JButton next = new JButton("");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(sf.format(cal.getTime()));  System.out.println(dat.format(DateTimeFormatter.ofPattern("MMM-yyyy-dd")));
				if( sf.format(cal.getTime()).equals(dat.format(DateTimeFormatter.ofPattern("MMM-yyyy-dd"))))
				{
					System.out.println("entered");
					return;
				}
				cal.add(cal.DATE,1);
				if(new File(d.filePath+"Dairy\\"+sf.format(cal.getTime())+".txt").exists())
				{
					try {
						extractFrom(d.filePath+"Dairy\\"+sf.format(cal.getTime())+".txt");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					  next.doClick();
				} 
			}
		});
		next.setBackground(new Color(240, 240, 240));
		next.setBounds(1302, 337, 33, 115);
		contentPane.add(next);
		
	    page = new JLabel("");
		page.setFont(new Font("Tahoma", Font.PLAIN, 15));
		page.setBounds(676, 12, 162, 23);
		page.setText(sf.format(cal.getTime()));
		contentPane.add(page);
		
		 setLocationRelativeTo(null);
		 
	}
	void extractFrom(String path) throws IOException
	{   
		page.setText(sf.format(cal.getTime()));
		
		File  f = new File(path);
		FileReader fr = new FileReader(f);
		int i;  StringBuilder sb = new StringBuilder();
		while((i=fr.read())!=-1)
		{
			sb.append((char)i);
		}
		textArea.setText(sb.toString()); 
		fr.close();
	}
}
