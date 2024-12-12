import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//********************** THE ABOUT PAGE****************** 
public class AboutPage extends JFrame implements ActionListener
{
	
	static JButton ok;
	public void showFrame()
	{
		
		Container c=this.getContentPane();
		
		//label
		JLabel title=new JLabel("Image");
		title.setIcon(new ImageIcon("images\\about.jpg"));
		//title.setSize(100,100);
		
		//text area
		JTextArea about=new JTextArea(200,150);
		about.setEditable(false);
		about.setText("Welcome to Medical Management System \n\nObjectivity: The Project is Aimed at providing ease in maintaing and handling the stocks\n of medicines.Along with it, The application provides facility to generate patient's report\n that will allow the doctor to treat the patient in best possible way");
		about.setFont(new Font("Times New Roman",Font.ITALIC,15));
		about.setBackground(Color.BLACK);
		about.setForeground(Color.WHITE);
		
		
		
		ok=new JButton("OK");
		
		JPanel p=new JPanel();
		p.add(ok);
		
		
		c.add(title,BorderLayout.NORTH);
		c.add(about,BorderLayout.CENTER);
		c.add(p,BorderLayout.SOUTH);
		
		this.setTitle("About");
		this.setVisible(true);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ok.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ok)
		{
			dispose();
		}	
	}
}
