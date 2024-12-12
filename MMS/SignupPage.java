import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//**************** SIGN UP PAGE **************************
class SignupPage extends JFrame implements ActionListener,ItemListener,FocusListener
{
	static JButton signup, back, report;
	static JTextField fname,lname,email,uname,auth;
	static JPasswordField pass, pass2;
	static Checkbox accept;
	static Choice rights;
	public void showFrame()
	{
		Container c=this.getContentPane();
		JLabel msg=new JLabel("Welcome! Get Signed Up");

		//************** Creating all the components
		
		JLabel lb1=new JLabel("First Name   :");
		JLabel lb2=new JLabel("Last Name   :");
		JLabel lb3=new JLabel("Email Id   :");
		JLabel lb4=new JLabel("Prefered username   :");
		JLabel lb5=new JLabel("Authentication number   :");
		JLabel lb6=new JLabel("User Rights   :");
		JLabel lb7=new JLabel("Password   :");
		JLabel lb8=new JLabel("Confirm Password   :");
		
		fname=new JTextField(20);
		lname=new JTextField(20);
		email=new JTextField(20);
		uname=new JTextField(20);
		auth=new JTextField(20);
		
		//choice for user rights
			rights=new Choice();
			rights.add("Billing Only");
			rights.add("Billing and Managing Stocks");
		//passwordFields
		pass=new JPasswordField(20);
		pass2=new JPasswordField(20);
		
		//**** declaration of correctness of data
			accept=new Checkbox("I hearby declare that the information provided by me above is correct.",false);
			JLabel lbl=new JLabel("And only I will be responsible for any kind inconvenience caused by incorrect information");
			
		//********** Creating the button ***************
		
		signup=new JButton("Sign UP");		signup.setEnabled(false);
		back=new JButton("Back");
		report=new JButton("Generate Report");
		
		//********************* Adding all the components panel p2********
				JPanel p2=new JPanel();
				p2.setLayout(null);
				
				//setting size of components
					//labels
					lb1.setSize(150,23);
					lb2.setSize(150,23);
					lb3.setSize(150,23);
					lb4.setSize(150,23);
					lb5.setSize(150,23);
					lb6.setSize(150,23);
					lb7.setSize(150,23);
					lb8.setSize(150,23);
					//textFields etc.
					fname.setSize(280,23);
					lname.setSize(280,23);
					email.setSize(280,23);
					uname.setSize(280,23);
					auth.setSize(280,23);
					rights.setSize(280,23);
					pass.setSize(280,23);
					pass2.setSize(280,23);
				//setting location of components
					//labels
					lb1.setLocation(100,30);
					lb2.setLocation(100,60);
					lb3.setLocation(100,90);
					lb4.setLocation(100,120);
					lb5.setLocation(100,150);
					lb6.setLocation(100,180);
					lb7.setLocation(100,210);
					lb8.setLocation(100,240);
					//textFiels etc.
					fname.setLocation(300,30);
					lname.setLocation(300,60);
					email.setLocation(300,90);
					uname.setLocation(300,120);
					auth.setLocation(300,150);
					rights.setLocation(300,180);
					pass.setLocation(300,210);
					pass2.setLocation(300,240);
					
					//agreement 
					accept.setSize(500,22);
					accept.setLocation(80,300);
					
					lbl.setSize(510,22);
					lbl.setLocation(75,324);
			
			//adding all these components to JPanel p2
			p2.add(lb1);
			p2.add(lb2);
			p2.add(lb3);
			p2.add(lb4);
			p2.add(lb5);
			p2.add(lb6);
			p2.add(lb7);
			p2.add(lb8);
			p2.add(fname);
			p2.add(lname);
			p2.add(email);
			p2.add(uname);
			p2.add(auth);
			p2.add(rights);
			p2.add(pass);
			p2.add(pass2);
			
			p2.add(accept);
			p2.add(lbl);
		
		//********** Panel p1 holds the three buttons ***************
		JPanel p1=new JPanel();
		p1.add(signup);
		p1.add(back);
		p1.add(report);
		
		//*************** Formatting with the components ****************************
		msg.setIcon(new ImageIcon("images\\signup.jpg"));
		
		
		//************* Adding the panel p1,p2 to the Sign up FRAME ********************
		c.add(p1,BorderLayout.SOUTH);			//panel added to South
		c.add(msg,BorderLayout.NORTH);			//Message Label added to NORTH
		c.add(p2,BorderLayout.CENTER);			//information panel added to center
		
		this.setTitle("Sign Up");
		this.setVisible(true);
		this.setSize(700,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//****************************Adding Listeners

		signup.addActionListener(this);
		back.addActionListener(this);
		report.addActionListener(this);
		
		accept.addItemListener(this);
		
		fname.addFocusListener(this);
		lname.addFocusListener(this);
		email.addFocusListener(this);
		uname.addFocusListener(this);
		auth.addFocusListener(this);
		pass.addFocusListener(this);
		pass2.addFocusListener(this);
	}
	
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e)
	{
		/*
			Displays the error message if the authintication is false and the textField is not empty.
			Sets the textField blank if there is invalid entry
			Else, sets the textField with varified entry 
		*/
		
		Validity v=new Validity();
		Component c=e.getComponent();
		
		if(c==fname)
		{
			
			if(v.name(fname.getText())==false && !(fname.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Invalid First Name!");
				fname.setText(" ");
			}
			else
			{
				fname.setText(v.setVarifiedString());
			}
				
		}
		else if(c==lname)
		{
			if(v.name(lname.getText())==false && !(lname.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Invalid Last Name!");
				lname.setText("");
			}	
			else
			{
				lname.setText(v.setVarifiedString());
			}
		}
		else if(c==email)
		{
			if(v.email(email.getText())==false && !(email.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Invalid Email Address!");
				email.setText("");
			}
			else
			{
				email.setText(v.setVarifiedString());
			}
		}
		else if(c==uname)
		{
			
			if(v.username(uname.getText())==false && !(uname.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Username must be Alphanumeric and minimum 6 char long.");
				uname.setText("");
			}
			
			else
			{
			userexist u=new userexist();//creating object of class to check user
			boolean b=true;//variable to check whether user is available in table or not
			
			b=u.user(uname.getText());//storing  integer type value by passing 
			if(b==true)
			{
				JOptionPane.showMessageDialog(this,"username already exist");
				uname.setText("");
			}
			else
				uname.setText(v.setVarifiedString());
			}
		}
		else if(c==auth)
		{
			if(v.authentication(auth.getText())==false && !(auth.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Incorrect authentication number!");
				auth.setText("");
			}	
		}
		else if(c==pass)
		{
			if(pass.getText().length()<6  && !(pass.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Password must be minimum 6 characters long");
				pass.setText("");
			}
		}
		else if(c==pass2)
		{
			if(!(pass.getText().equals(pass2.getText()))  && !(pass2.getText().equals("")))
			{
				JOptionPane.showMessageDialog(this,"Confirmation Password does not match!");
			}
		}
		
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(accept.getState())
		{
			signup.setEnabled(true);
		}
		else
		{
			signup.setEnabled(false);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Validity v=new Validity();
		
		if(e.getSource()==signup)
		{
			String s1,s2,s3,s4,s5,s6,s7;
			s1=fname.getText();
			s2=lname.getText();
			s3=email.getText();
			s4=uname.getText();
			s5=auth.getText();
			s6=pass.getText();
			s7=pass2.getText();
			
			
			if(v.noEmptyFields(s1,s2,s3,s4,s5,s6,s7))
			{	
				if(v.name(s1)&&v.name(s2)&&v.email(s3)&&v.username(s4)&&v.authentication(s5)&&v.password(s6,s7))
				{
				
					/*-------Code and methods for storing this signup data goes here-----------------
					after validating all fields of sign up frame
					InsertsignUp class object  i is created
					and after that all values
					that is first name for s1
					last name for s2
					email for s3,username for s4,
					authentication number for s5,
					users right for r
					and passord for s6 */
					
					InsertSignUp i=new InsertSignUp();
					String r=rights.getSelectedItem();
					i.InsertUser(s1,s2,s3,s4,s5,r,s7);
					SignedUpPage h=new SignedUpPage();
					dispose();
					
					h.str1=uname.getText();
					h.str2=fname.getText();
					h.str3=lname.getText();
					h.showFrame();
					
				}
				else
					JOptionPane.showMessageDialog(this,"Incorrect Password!");
			}
			else
				JOptionPane.showMessageDialog(this,"All the fields are Mandotary!");
		}
		else if(e.getSource()==back)
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

