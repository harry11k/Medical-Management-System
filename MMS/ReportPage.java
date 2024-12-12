import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//**************** REPORT PAGE **************************
class ReportPage extends JFrame implements ActionListener, ItemListener
{
	
	static JButton next,back; 
	static JTextField name,age,specify; // Text Fields nam,age that take input of Name and Age respectively
	static Choice sex,type; // gen to creat choice box to select gender and spec to select the specific illnes related with
		
	public void showFrame()
	{
		Container c=this.getContentPane();
		
		//********** Creating required componets
		//Labels
		JLabel msg=new JLabel("HOME");
		
		JLabel lbl1=new JLabel("Name :");
		JLabel lbl2=new JLabel("Sex  :");
		JLabel lbl3=new JLabel("Age  :");
		JLabel lbl4=new JLabel("Problem related to :");
		JLabel lbl5=new JLabel("Specify your problem in short if your selection is OTHER");
		
		//buttons
		
		next=new JButton(" Next ");
		back=new JButton("Back");
		
		//textbox
		name=new JTextField(20);
		age=new JTextField(5);
		
		specify=new JTextField(30);
		specify.setEnabled(false); //to keep the specify textbox disabled until user select other
		
		//CHoice box
		sex=new Choice();
		//sex.add(" ");
		sex.add("Male");
		sex.add("Female");
		
		// type choice box to Specify the illnes is related to
		
		type=new Choice();
		type.add("Cough and Cold");
		type.add("Mental Illness");
		type.add("Eyes");
		type.add("Bones");
		type.add("Stomac and Appetite");
		type.add("Skin and Beauty");
		type.add("Dental");
		type.add("Sexual");
		type.add("OTHER");
		
		//************ Creating Button Panel ************************************
		JPanel bp=new JPanel();
		bp.add(back);
		bp.add(next);
		
		//*********** Creating data entry Panels ************************************
		
		JPanel namePan=new JPanel();
		namePan.add(lbl1);
		namePan.add(name);
		
		JPanel sexPan=new JPanel();
		sexPan.add(lbl2);
		sexPan.add(sex);
		
		JPanel agePan=new JPanel();
		agePan.add(lbl3);
		agePan.add(age);
		
		JPanel typePan=new JPanel();
		typePan.add(lbl4);
		typePan.add(type);
		
		JPanel specPan=new JPanel();  //specify panel
		specPan.add(lbl5);
		specPan.add(specify);
		
		
		JPanel entryPan=new JPanel();
		entryPan.setLayout(new GridLayout(5,1));
		entryPan.add(namePan);
		entryPan.add(sexPan);
		entryPan.add(agePan);
		entryPan.add(typePan);
		entryPan.add(specPan);
		
		
		//************** Formatting the components *********************************
				msg.setIcon(new ImageIcon("images\\report.jpg"));
				//login.setBackground(Color.BLUE);
				//login.setForeground(Color.WHITE);
	
		//************* Positioning and Adding the components to Container ********************
		
		c.add(msg,BorderLayout.NORTH);
		c.add(entryPan,BorderLayout.CENTER);
		c.add(bp,BorderLayout.SOUTH);
		
		//*************** Setting up the Frame Properties
		this.setTitle("Home");
		this.setVisible(true);
		this.setSize(800,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//************* Adding listeners to all the three buttons *************************
		next.addActionListener(this);
		back.addActionListener(this);
		
		//name.addFocusListener(this);
		
		type.addItemListener(this);
	}
	
	
	public void itemStateChanged(ItemEvent e)
	{
		String s=type.getSelectedItem();
		
		if(s.equals("OTHER"))
			specify.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==next)
		{
			InsertTableHome th=new InsertTableHome();//class to insert report information in table
			String n=name.getText();//stores value of name
			
			String s=sex.getSelectedItem();//stores value of sex
			String t=type.getSelectedItem();//stores value of problem
			
			//passing value of name and age for validation purpose
			ValidateHome vh=new ValidateHome();
			boolean va=vh.valid(n,age.getText());
			
			if(va==false)
			{	
				JOptionPane.showMessageDialog(this,"Invalid column field");
				name.setText("");
				age.setText("");
				sex.select("Male");
				type.select("Cough and Cold");
			}
			else 
			{
				int a=Integer.parseInt(age.getText());//stores value of age
				boolean b=th.Home(n,a,s,t);	
				//passing value of name,age,sex,type that is problem 
				//to class Insert table Home so that value can be inserted in table
				//variable b is used to check whether value is successfully inserted or not
				
				if(b==false)
					JOptionPane.showMessageDialog(this,"Error while inserting");
				else
					JOptionPane.showMessageDialog(this,"Successfully inserted");
				
				ExaminPage h=new ExaminPage();
				dispose();
				h.showFrame();
				
				/*get function is defined in
				ExaminPage to set value
				of name,age,sex and problem
				so we are passing four values*/
				
				h.get(n,age.getText(),s,t);
			}
		}
		else if(e.getSource()==back)
		{
			if(Medical.active.equals("LoginPage"))
			{
				LoginPage h=new LoginPage();
				h.showFrame();
			}
			else if(Medical.active.equals("MainMenu"))
				new MainMenu();
			
				dispose();
		}
	}
}
