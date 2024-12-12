import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//***************** LOGIN PAGE **************************
class LoginPage extends JFrame implements ActionListener
{
	static JButton report, signup, login;
	static JTextField user;
	static JPasswordField pass;
	static JRadioButton rb1,rb2;  // to select the rights you hava with the account
	static ButtonGroup g;
	public void showFrame()
	{
		Medical.active="LoginPage";
		
		Container c=this.getContentPane();
		
		JLabel msg=new JLabel("LogIn to get access to the Stocks and Short List the Medicines...");
		
		//******** Creating the button and adding to pannel ****************
		login=new JButton("Log In");
		signup=new JButton("Sign Up");
		report=new JButton("Generate Report");
		
		
			//******* Creating other Components ************
		JLabel lbl1=new JLabel("Log in as:");
		JLabel lbl2=new JLabel("Username");
		JLabel lbl3=new JLabel("Password");
		
		g=new ButtonGroup();
		rb1=new JRadioButton("Billing Only",true);
		rb2=new JRadioButton("Stock Handler",false);
		g.add(rb1);
		g.add(rb2);
		
		user=new JTextField(20);
		pass=new JPasswordField(20);
		
			//************ Adding these components Panel by Panel*******
			
			JPanel selectPan=new JPanel();  //Panel to hold the selection radio box
			selectPan.add(lbl1);
			selectPan.add(rb1);
			selectPan.add(rb2);
			
			JPanel userPan=new JPanel();	//Panel to hold user name contents	
			userPan.add(lbl2);
			userPan.add(user);
			
			JPanel passPan=new JPanel();	//Panel to hold password contents	
			passPan.add(lbl3);
			passPan.add(pass);
			
			
			JPanel p2=new JPanel();			//Panel p2 holds all the above panels
			p2.setLayout(new GridLayout(3,1));
			p2.add(selectPan);
			p2.add(userPan);
			p2.add(passPan);
			
			
				//**** Panel p holds the three buttons ***************
				JPanel p1=new JPanel();
				p1.add(login);
				p1.add(signup);
				p1.add(report);
			
		//********************** Formating with the Components ************************
		
		msg.setIcon(new ImageIcon("images\\login.jpg"));
		
		//************* Adding the panel p1 and p2 to the LOGIN FRAME ********************
		c.add(p2,BorderLayout.CENTER);
		c.add(p1,BorderLayout.SOUTH);			//Button panel added to South
		c.add(msg,BorderLayout.NORTH);			//Message added to Centre
		
		//*************** Setting Frame properties *********************
		
		this.setTitle("Log in");
		this.setVisible(true);
		this.setSize(800,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login.addActionListener(this);
		signup.addActionListener(this);
		report.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==login)
		{
			String usr=user.getText();
			String psw=pass.getText();
			
			/*---------------------------------------------------------------------
			code for getting username and password from the database goes here. */
			
			userchek u=new userchek();//creating object of class to check user
			int b=0;//variable to check whether user is available in table or not
			
			b=u.check(usr,psw);//storing  boolean type value by passing 
								//user name and password to the funtion check of class usercheck
			
			boolean superRights=false;
			
			/*	if b=2 is returned from check method
				of userchek class then 
				user hava permission to access
				all pages that is superrights is true
				else if b=1 then user have 
				only permission to access billing page
				not stock handler page	*/
			if(b==2)
				superRights=true;
				
			//----------------------------Grants for super user -------------------
			
			if(usr.equals("superuser"))
				superRights=true;
			//---------------------------------------------------------------------
		//if boolean type variable b returns true then it is registered user
			if(usr.equals("superuser")&&psw.equals("nkk50kkk")||b==1||b==2)
			{
				if(rb1.isSelected())
				{
					BillingPage p=new BillingPage();
					p.showFrame();
					dispose();
				}
				else if(rb2.isSelected())
				{
					if(superRights)
					{
						//StockHandlerPage p=new StockHandlerPage();
						//p.showFrame();
						new MainMenu();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this,"You don't have the rights to login as Stock Handler!");
					}	
				}
			}
			else
			{
				user.setText("");
				pass.setText("");
				JOptionPane.showMessageDialog(this,"Invalid username or password!");
			}
		}
		else if(e.getSource()==signup)
		{
			SignupPage h=new SignupPage();
				dispose();
				h.showFrame();
		}
		else if(e.getSource()==report)
		{
			ReportPage h=new ReportPage();
				h.showFrame();
		}
	}
}
