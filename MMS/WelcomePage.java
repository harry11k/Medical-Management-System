import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//**************** THE WELCOME PAGE **********************
class WelcomePage extends JFrame implements ActionListener
{
	static JButton start, exit, about;
	public void showFrame()
	{
		
		this.setLayout(null);
		Container c=this.getContentPane();
		
		JLabel lbl=new JLabel();
		
		start=new JButton("Get Started");
		exit=new JButton("Exit");
		about=new JButton("About");
		
		//*************** Adding Image to the Component***********************
		lbl.setIcon(new ImageIcon("images\\welcome.jpg"));
		
		//********** Coloring ,Postioning and Resizing the Components and ***************
		start.setBackground(Color.BLUE);
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Times New Roman",Font.BOLD,18));
		start.setToolTipText("Press the button to open login window");
		
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Times New Roman",Font.BOLD,15));
		exit.setToolTipText("Press to close");
		
		about.setBackground(Color.YELLOW);
		about.setForeground(Color.BLACK);
		about.setFont(new Font("Times New Roman",Font.BOLD,15));
		about.setToolTipText(" It contains Hospital information");
		
		start.setSize(80,40);
		start.setLocation(310,350);

		about.setSize(80,40);
		about.setLocation(50,350);
			
		exit.setSize(80,40);
		exit.setLocation(640,350);
		
		lbl.setSize(800,400);
		lbl.setLocation(0,0);
		
		//*************** Adding to Container *************************
		c.add(start);
		c.add(exit);
		c.add(about);
		c.add(lbl);
		
		//**************** Frame Properties ***********************
		this.setTitle("Welcome to Fortis Hospital");
		this.setVisible(true);
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		about.addActionListener(this);
		start.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==start)
		{
				LoginPage h=new LoginPage();
				dispose();
				h.showFrame();
		} 
		else if(e.getSource()==exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==about)
		{
			AboutPage a=new AboutPage();
			a.showFrame();
		}
	}
}

