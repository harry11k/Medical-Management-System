import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//**************** SIGNED UP PAGE ************************
class SignedUpPage extends JFrame implements ActionListener
{
	static String str1="superuser";
	static String str2,str3;
	static JButton login,report;
	public void showFrame()
	{
		Container c=this.getContentPane();
		login=new JButton("Login");
		report=new JButton("Generate Report");
		
		JPanel buttons=new JPanel();
		buttons.add(login);
		buttons.add(report);
		//----------- username label-------------
		JLabel user=new JLabel(str1);
		
		JPanel detail=new JPanel();
		detail.add(new JLabel("User username is :      "));
		detail.add(user);
		
		JPanel msgPan=new JPanel();
		msgPan.add(new JLabel(" Congratulations, "+str2+" "+str3+". "));
		msgPan.add(new JLabel("Your Account created successfully!"));
		
		c.add(msgPan,BorderLayout.NORTH);
		c.add(buttons,BorderLayout.SOUTH);
		c.add(detail,BorderLayout.CENTER);
		
		//setting up Frame Properties
		this.setVisible(true);
		this.setSize(500,130);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("SignUp successful!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//adding listeners
		report.addActionListener(this);
		login.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login)
		{
		LoginPage h=new LoginPage();
				dispose();
				h.showFrame();
		}
		else if(e.getSource()==report)
		{
			
			ReportPage h=new ReportPage();
				dispose();
				h.showFrame();
		}
	}
	
	
}
