import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//**************** STOCK HANDLER PAGE ********************
class StockHandlerPage extends JFrame implements ActionListener,ItemListener
{
	/*
	NOTE:	 in card2 , del(RadioButton) 
			i.e. 'delete' is used for
			search, delete as well as modificaion.
			while modification is transfered to card1 add(Radio Button)
	*/
	//Declarations for the Entire Frame 
	static	JRadioButton add,del,view;
	static	CardLayout clo;
	static 	JPanel cards; //card1 and card2
	static 	JButton back;
	
	//Declarations for Card1
	static JButton addr;
	static JTextField code1,name1,quan1,rate1,mrp1;
	static Choice exp1,exp2;
	
	//Declarations for card2
	static 	JTextField searchbox;
	static 	JButton search;
	static 	JTextField name,quan,rate,mrp,exp;
	static 	JButton delete,modify;
	
	static String date;
	 //used for containing date
	
	public void showFrame()
	{
		Container c=this.getContentPane();
		
		//---------header -------------
		JLabel title=new JLabel("Add, Delete or Modify the Records here :"); 	//Title
		
		ButtonGroup g=new ButtonGroup(); 									//RadioButton
		add=new JRadioButton("Add",true);
		del=new JRadioButton("Search/Delete/Modify Records",false);
		view=new JRadioButton("View Stock",false);
		g.add(add);
		g.add(del);
		g.add(view);
		
		JPanel rbutton=new JPanel();
		rbutton.add(add);
		rbutton.add(del);
		rbutton.add(view);
		
		JPanel p=new JPanel();												//Title + RadioButton Panel
			p.add(title);
			p.add(rbutton);
			
			//----- Back BUTTON
		back=new JButton("Back");
		
		JPanel toolbar=new JPanel();
		toolbar.setLayout(new BorderLayout());
		toolbar.add(back,BorderLayout.EAST);
		toolbar.add(p);
			
		//---------Body-----------------
		
		JPanel card1,card2;
		card1=new JPanel();
		card2=new JPanel();
		
		clo=new CardLayout();
		cards=new JPanel();
		cards.setLayout(clo);
		
		cards.add(card1,"ADD");
		cards.add(card2,"DELETE");
		
		card1.setLayout(null);  card1.setBackground(Color.WHITE);
		card2.setLayout(null);	card2.setBackground(Color.WHITE);
		
		//--- Designing THE CARDS------ CARD1 and CARD2 --------------------
		
			//########## CARD 1 ##############
				
				//ADD button and Title
				JLabel c1title=new JLabel("Enter the Details of the Medicine:");	//title
				c1title.setFont(new Font("Times New Roman",Font.BOLD,18));
				c1title.setSize(320,35);
				c1title.setLocation(350,10+30);
				
				addr=new JButton("ADD RECORD");
				addr.setSize(150,30);
				addr.setLocation(630,310);
				
				//-------------------------------Setting up size of other labels and textFields
				JLabel ll0=new JLabel("Product Code  :");
				JLabel ll1=new JLabel("Medicine Name  :");
				JLabel ll2=new JLabel("Quantity  :");
				JLabel ll3=new JLabel("Rate  :");
				JLabel ll4=new JLabel("MRP  :");
				JLabel ll5=new JLabel("Exp. (MM/YYYY)  :");
				
				code1=new JTextField();
				name1=new JTextField();
				quan1=new JTextField();
				rate1=new JTextField();
				mrp1=new JTextField();
				exp1=new Choice();
				exp2=new Choice();
				
				exp1.add("January");
				exp1.add("February");
				exp1.add("March");
				exp1.add("April");
				exp1.add("May");
				exp1.add("June");
				exp1.add("July");
				exp1.add("August");
				exp1.add("September");
				exp1.add("October");
				exp1.add("November");
				exp1.add("December");
				
				//this for loop is used
				//to insert value in year combo box
				
				for(int i=2017;i<=2029;i++)
				{
					String st=String.valueOf(i);
					exp2.add(st);
					
				}
				
						//Label size 
						ll0.setSize(100,30);
						ll1.setSize(100,30);
						ll2.setSize(100,30);
						ll3.setSize(100,30);
						ll4.setSize(100,30);
						ll5.setSize(100,30);
						//TextField size
						code1.setSize(280,28);
						name1.setSize(280,28);	
						quan1.setSize(100,28);	
						rate1.setSize(100,28);	
						mrp1.setSize(100,28);	
						exp1.setSize(90,28);
						exp2.setSize(58,28);
						
						//Label Location
						ll0.setLocation(50+100,60+50);
						ll1.setLocation(50+100,100+50);
						ll2.setLocation(50+100,140+50);
						ll3.setLocation(50+100,180+50);
						ll4.setLocation(50+100,220+50);
						ll5.setLocation(50+100,260+50);
						//textField location
						code1.setLocation(200+100,60+50);
						name1.setLocation(200+100,100+50);
						quan1.setLocation(200+100,140+50);
						rate1.setLocation(200+100,180+50);
						mrp1.setLocation(200+100,220+50);
						exp1.setLocation(200+100,260+50);
						exp2.setLocation(200+190,260+50);
				//---Adding components to card2
				
				card1.add(c1title);
				card1.add(ll0);
				card1.add(ll1);
				card1.add(ll2);
				card1.add(ll3);
				card1.add(ll4);
				card1.add(ll5);
				card1.add(code1);
				card1.add(name1);
				card1.add(quan1);
				card1.add(rate1);
				card1.add(mrp1);
				card1.add(exp1);
				card1.add(exp2);
				card1.add(addr);
				
			
			//########## CARD 2 ##############
				
				JLabel c2title=new JLabel("Enter the Product Code to search for : ");	//title
				c2title.setFont(new Font("Times New Roman",Font.BOLD,18));
				c2title.setSize(320,35);
				c2title.setLocation(350,10+30);
				
				searchbox=new JTextField();										//search box
				searchbox.setSize(350,30);
				searchbox.setLocation(250,50+30);
				
				search=new JButton("SEARCH RECORD");							//search button
				search.setSize(150,30);
				search.setLocation(630,50+30);
				
				//DELETE and MODIFY button
				
				delete=new JButton("DELETE RECORD");
				modify=new JButton("MODIFY RECORD");
				modify.setEnabled(false);
				
				delete.setSize(150,30);
				modify.setSize(150,30);
				
				delete.setLocation(630,240);
				modify.setLocation(630,310);
				
				//-------------------------------Setting up size of other labels and textFields
				JLabel l1=new JLabel("Medicine Name  :");
				JLabel l2=new JLabel("Quantity  :");
				JLabel l3=new JLabel("Rate  :");
				JLabel l4=new JLabel("MRP  :");
				JLabel l5=new JLabel("Exp. (MM-YYYY)  :");
				
				name=new JTextField();
				quan=new JTextField();
				rate=new JTextField();
				mrp=new JTextField();
				exp=new JTextField();
				
						//Label size 
						l1.setSize(100,30);
						l2.setSize(100,30);
						l3.setSize(100,30);
						l4.setSize(100,30);
						l5.setSize(100,30);
						//TextField size
						name.setSize(300,28);	name.setEditable(false);
						quan.setSize(100,28);	quan.setEditable(false);
						rate.setSize(100,28);	rate.setEditable(false);
						mrp.setSize(100,28);	mrp.setEditable(false);
						exp.setSize(100,28);	exp.setEditable(false);						
						
						//Label Location
						l1.setLocation(50+100,100+50);
						l2.setLocation(50+100,140+50);
						l3.setLocation(50+100,180+50);
						l4.setLocation(50+100,220+50);
						l5.setLocation(50+100,260+50);
						//textField location
						name.setLocation(200+100,100+50);
						quan.setLocation(200+100,140+50);
						rate.setLocation(200+100,180+50);
						mrp.setLocation(200+100,220+50);
						exp.setLocation(200+100,260+50);
						
				//---Adding components to card2
				card2.add(c2title);
				card2.add(searchbox);
				card2.add(search);
				card2.add(l1);
				card2.add(l2);
				card2.add(l3);
				card2.add(l4);
				card2.add(l5);
				card2.add(name);
				card2.add(quan);
				card2.add(rate);
				card2.add(mrp);
				card2.add(exp);
				card2.add(delete);
				card2.add(modify);
				
			
		c.add(toolbar,BorderLayout.NORTH);
		c.add(cards,BorderLayout.CENTER);
		
		
		//----------------Setting up frame properties----------------
		setTitle("Test");
		setVisible(true);
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//----------------- Adding Listeners ------------------------
		
		addr.addActionListener(this);
		search.addActionListener(this);
		modify.addActionListener(this);
		delete.addActionListener(this);
		back.addActionListener(this);
		
		add.addItemListener(this);
		view.addItemListener(this);
		del.addItemListener(this);
		
		exp1.addItemListener(this);
		exp2.addItemListener(this);
		
	}		
	/*get function is used to get value from
	searchstock table so that it can be
	inserted in the textbox	it accepts 5 variables
	nam is for name,qua for quantity,ra for rate
	mr for mrp and exp2 for containing expiry variables*/
	
	public void get(String nam,int qua,double ra,double mr,String exp2)	//funtion to set text value after search
	{
		name.setText(nam);
		quan.setText(String.valueOf(qua));
		rate.setText(String.valueOf(ra));
		mrp.setText(String.valueOf(mr));
		exp.setText(exp2);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(add.isSelected())
		{
			clo.show(cards,"ADD");
		}
		else if(del.isSelected())
		{
		 	clo.show(cards,"DELETE");
		}
		else if(view.isSelected())
		{
			/* when view radio button is selected
			then stockjtable class object sj
			is created and table is shown in jtable
			format */
			
			StockJTable sj=new StockJTable();
			sj.showFrame();
			dispose();
		}
		
	}
	
	/* clear function is used to clear 
	all previos values of text box and list box
	to previous stage to perform another operation */
	
	public void clear()
	{
		code1.setText("");
		name1.setText("");
		quan1.setText("");
		rate1.setText("");
		mrp1.setText("");
		exp1.select("January");
		exp2.select("2017");
	}
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==back)
			{
				new MainMenu();
				dispose();
			}
			else if(e.getSource()==delete)
			{
				/* Deletestock class object d
				is created then
				code value is passed to delete method
				if it is not equal to null */
				
				DeleteStock d=new DeleteStock();
				String c=searchbox.getText();
				
				if(c.equals(""))
				{
					JOptionPane.showMessageDialog(this,"Product code invalid");
					searchbox.setText("");
				}
				else
				{
					boolean b=d.Delete(c);
					if(b==true)
						JOptionPane.showMessageDialog(this,"Successfully deleted");
					else if(b==false)
						JOptionPane.showMessageDialog(this,"Product code not available");
					name.setText("");
					quan.setText("");
					rate.setText("");
					mrp.setText("");
					exp.setText("");
					searchbox.setText("");
				}
			}
			else if(e.getSource()==addr)
			{
				/* first code value is given
				to variable c then check that
				if length is less than 3 or does
				not containing null values */
				
				String c=code1.getText();
				
				
				if(c.length()<3 || c.equals("") ||c.length()>13)
				{
					JOptionPane.showMessageDialog(this,"Invalid product code");
					//clear();
				}
				else
				{
					/* checkcode class object ch is created
					then method check is called and passed
					code that whether code already exists in table
					or not  boolean type variable cod get value
					from check method if it returns false
					then code doesnot exists in table and new record
					is to be inserted otherwise update the 
					values in the existing record of table*/

					CheckCode ch=new CheckCode();
					boolean cod=ch.Check(c);
					
					if(cod==false)
					{
						/* after that valid method of validatestock
						class is called and check that whether
						all value of inserted field is valid or not
						it passes 4 values of textbox	valid 
						method returns boolean type variable
						if it returns true then value is inserted
						in the table else error message in the
						form of message dialog box is generated	*/
						
						ValidateStock vs=new ValidateStock();
						boolean v=vs.valid(name1.getText(),quan1.getText(),rate1.getText(),mrp1.getText());
						if(v==true)
						{
							String n=name1.getText();
							int q=Integer.parseInt(quan1.getText());
							double r=Double.parseDouble(rate1.getText());
							double m=Double.parseDouble(mrp1.getText());
							
							String ex;//used to concate date value
							
							String month=exp1.getSelectedItem();
							String year=exp2.getSelectedItem();
							
							ex=month+year;
							
							InsertStock Is=new InsertStock();//creating object of class that insert stock
							//passing value to insert table function
							
							c=c.trim();
							c=c.toUpperCase();
							boolean bo=Is.Stock(c,n,q,r,m,ex);
							
							/* after inserting in table by passing all
							values in stock method of insertstock
							class if it returns true then successfully inserted
							message is shown otherwise error message is displayed*/
							
							if(bo==true)
								JOptionPane.showMessageDialog(this," Successfully Added/Modified");
							else	
								JOptionPane.showMessageDialog(this,"Error while inserting");
						
							//after adding all textfields become empty
							clear();
						}
						else
						{	
							JOptionPane.showMessageDialog(this,"Invalid Data Provided");
							//clear();
						}
					}
					else
					{

						/*modify coding
						if code already exists in the table
						then automatically control comes to else
						part to update table record
						once again valid method of validatestock
						class is called and
						all values is passed to validate all
						fields it also returns boolean type variable
						it returns true if all are valid otherwise
						returns false in case of true operation of
						next step is to be performed otherwise generates
						error message */
						
						ValidateStock vst=new ValidateStock();
						boolean v=vst.valid(name1.getText(),quan1.getText(),rate1.getText(),mrp1.getText());
						if(v==true)
						{
							UpdateStock cs=new UpdateStock();
							String ca=code1.getText();
							String n=name1.getText();
							String q=quan1.getText();
							String r=rate1.getText();
							String m=mrp1.getText();
							String exw=exp1.getSelectedItem()+exp2.getSelectedItem();
							
							/* after storing all values in string type
							variable it is passed to upstock method
							of updatestock table 	*/
							
							boolean up=cs.upstock(ca,n,q,r,m,exw);
							if(up==true)
								JOptionPane.showMessageDialog(this,"Record Successfully updated");
							else
								JOptionPane.showMessageDialog(this,"Error while updating");
							clear();
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Invalid data feeded while modifying");
							clear();
						}
					}
				}	
			}
			else if(e.getSource()==search)
			{	
				/* after clicking on search  modify
				button is enabled so that  modify
				operatio can be performed only after searching
				operation*/
				modify.setEnabled(true);
				SearchStock se=new SearchStock();
				if(searchbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Invalid product code!");
					searchbox.setText(" ");
				}
				else
				{
					String c=searchbox.getText();
					c=c.trim();
					c=c.toUpperCase();
					if(se.Search(c)==false)
						JOptionPane.showMessageDialog(this,"code not available");
					else
						JOptionPane.showMessageDialog(this,"Successfully find");
				}
				
			}
			else if(e.getSource()==modify)
			{
				code1.setText(searchbox.getText());
				name1.setText(name.getText());
				quan1.setText(quan.getText()); 
				rate1.setText(rate.getText());
				mrp1.setText(mrp.getText());
				String c=searchbox.getText();
				
				SearchStock ss=new SearchStock();
				boolean bl=ss.Search(c);
			
				/*  c variable contains
				code value is to be sarched
				if it contains null value then
				searching operation is not performed
				if search method of serchstock class
				returns false then  record is not
				found error message is generated 
				otherwise success message is generated*/
				
				if(c.equals(""))
				{
					JOptionPane.showMessageDialog(this,"Product code invalid");
					searchbox.setText("");
				}
				else if(bl==false)
				{
					JOptionPane.showMessageDialog(this,"Product code not available");
					searchbox.setText("");
				}
					
				else
					add.setSelected(true);
				/* to modify control is transfered to 
				add record card after clicking on add button
				modify operation is performed then modify button
				is once again disabled and enabled again only 
				when searching operation is to be performed */
				
				modify.setEnabled(false);
			}	
	}
}
