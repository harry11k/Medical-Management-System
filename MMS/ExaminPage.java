import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//**************** EXAMIN PAGE ***************************
class ExaminPage extends JFrame implements ActionListener
{
	static JButton back,print,login; 
	
	static JTextField	name,age,sex,problem;
	static JTextArea detail;
	
	
	public void showFrame()
	{
		
		Container c=this.getContentPane();
		
		//********** Creating required componets
		//Labels
		
		JLabel lbl1=new JLabel("Name   :");
		JLabel lbl3=new JLabel("Sex    :");
		JLabel lbl2=new JLabel("Age    :");
		JLabel lbl4=new JLabel("Problem:");
		
		//****** Discription Box
		detail=new JTextArea(20,4);
		
		//buttons
		back=new JButton(" Back ");
		print=new JButton(" Print ");
		login=new JButton("Log In");
		
		//textbox
		name=new JTextField(30);
		age=new JTextField(5);
		sex=new JTextField(5);
		problem=new JTextField(30);
		
		name.setEditable(false);
		age.setEditable(false);
		sex.setEditable(false);
		problem.setEditable(false);
		
		
		//************ Adding components panel by panel ************************************
		
		JPanel p1=new JPanel();
			p1.add(lbl1);
			p1.add(name);
			p1.add(lbl2);
			p1.add(age);
		
		JPanel p2=new JPanel();
			p2.add(lbl3);
			p2.add(sex);
			p2.add(lbl4);
			p2.add(problem);
			
			
		
		//adding p1 and p2 to panel p3
		JPanel p3=new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(p1,BorderLayout.NORTH);
		p3.add(p2,BorderLayout.SOUTH);
		
		//Title of askPan
		JPanel tp=new JPanel();
		tp.add(new JLabel("Please answer these simple questions. It will take few seconds."));

		//components of askpane
		JPanel ex=new JPanel();
		ex.setLayout(new GridLayout(14,1));
		JTextField tf0=new JTextField();
		JTextField tf1=new JTextField();
		JTextField tf2=new JTextField();
		JTextField tf3=new JTextField();
		JTextField tf4=new JTextField();
		JTextField tf5=new JTextField();
		JTextField tf6=new JTextField();
		
		ex.add(new JLabel("            Enter Your height:"));
		ex.add(tf0);
		ex.add(new JLabel("            Enter your weight:"));
		ex.add(tf1);
		ex.add(new JLabel("            Enter your Blood Group:"));
		ex.add(tf2);
		ex.add(new JLabel("            Describe Your Problem"));
		ex.add(tf3);
		ex.add(new JLabel("            For how long you are facing this proble"));
		ex.add(tf4);
		ex.add(new JLabel("            Have you had any medication for this this earlier. If yes, Mention."));
		ex.add(tf5);
		ex.add(new JLabel("            Are going through any medication right now. If yes, Mention."));
		ex.add(tf6);
		
		
		
		//An askPan aka askPanel for interaction with the patient 
		JPanel askPan=new JPanel();
		askPan.setLayout(new BorderLayout());
		askPan.add(tp,BorderLayout.NORTH);
		askPan.add(ex,BorderLayout.CENTER);
		
			//buttons
		JPanel bp=new JPanel();
		bp.add(back);
		bp.add(print);
		bp.add(login);
		
		//************** Formatting the components *********************************
				
	
		//************* Positioning and Adding the components to Container ********************
		
		c.add(p3,BorderLayout.NORTH);
		c.add(askPan,BorderLayout.CENTER);
		c.add(bp,BorderLayout.SOUTH);
		
		//*************** Setting up the Frame Properties
		this.setTitle("Create Report");
		this.setVisible(true);
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//************* Adding listeners to all the three buttons *************************
		back.addActionListener(this);
		print.addActionListener(this);
		login.addActionListener(this);
		
	}
	
	/* get function is used to accept value
	from Report page so that value 
	inserted by user or patient 
	can be feeded in report page
	it accepts four string type values
	n for name,a for age,s for sex and p for problem*/
	
	public void get(String n,String a,String s,String p)
	{
		
		name.setText(n);
		age.setText(a);
		sex.setText(s);
		problem.setText(p);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
				if(Medical.active.equals("LoginPage"))
				{	
				LoginPage p=new LoginPage();
				p.showFrame();
				}
				else if(Medical.active.equals("MainMenu"))
				new MainMenu();
			
				dispose();
		} 
		else if(e.getSource()==print)
		{
			JOptionPane.showMessageDialog(this,"No printer available at the moment");
			
		}
		else if(e.getSource()==login)
		{
			LoginPage h=new LoginPage();
				dispose();
				h.showFrame();
		}
	}
}
