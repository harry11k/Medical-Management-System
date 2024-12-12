import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//**************** BILLING PAGE **************************
class BillingPage extends JFrame implements ActionListener,FocusListener
{
	static JButton viewC,addToC,back;
	static JTextField pCode,pName,inStock,price,netPrice;
	static Choice quan;
	static Double net;	
	int row=0;
	public void showFrame()
	{
		Container c=this.getContentPane();
		
		//creating header Components
		JLabel title=new JLabel("Product Billing");
		title.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		//creating footer Components
		viewC=new JButton("View Cart");
		addToC=new JButton("Add To Cart");
		back=new JButton("BACK");
		
		//Creating Body Components
			//--Labels
			
			JLabel lbl1=new JLabel("Product Code :");
			JLabel lbl2=new JLabel("Product Name :");
			JLabel lbl3=new JLabel("Quantity     :");
			JLabel lbl4=new JLabel("Left in Stock:");
			JLabel lbl5=new JLabel("Price(Rs)    :");
			JLabel lbl6=new JLabel("Net Price(Rs):");
			
			//--TextFields
			
			pCode=new JTextField(20);
			pName=new JTextField(20);		
			
			inStock=new JTextField(6);		
			price=new JTextField(10);		
			netPrice=new JTextField(10);	
			
			//quantity choice box
			quan=new Choice();
			quan.add("0");
			quan.add("1");
			quan.add("2");
			quan.add("3");
			quan.add("4");
			quan.add("5");
			
			pName.setEditable(false);
			inStock.setEditable(false);
			price.setEditable(false);
			netPrice.setEditable(false);
			
		// Positioning the Components
		
			//--------Title---------------
			title.setLocation(10,10);
			title.setSize(150,35);
			//---------Buttons------------
			viewC.setLocation(50,470);
			viewC.setSize(100,33);
			//----------------------
			addToC.setLocation(50+125,470);
			addToC.setSize(100,33);
			//--------------------------
			back.setLocation(550,470);
			back.setSize(100,33);
			//-------Labels and TextBox---------------
					//size label
					lbl1.setSize(100,30);
					lbl2.setSize(100,30);
					lbl3.setSize(100,30);
					lbl4.setSize(100,30);
					lbl5.setSize(100,30);
					lbl6.setSize(100,30);
				//location label
				lbl1.setLocation(50,100);
				lbl2.setLocation(50,150);
				lbl3.setLocation(50,200);
				lbl4.setLocation(50,250);
				lbl5.setLocation(50,300);
				lbl6.setLocation(350,350);
					//size textbox
					pCode.setSize(400,28);
					pName.setSize(400,28);
					quan.setSize(100,28);
					inStock.setSize(100,28);
					price.setSize(100,28);
					netPrice.setSize(100,28);
				//location textbox
				pCode.setLocation(150,100);
				pName.setLocation(150,150);
				quan.setLocation(150,200);
				inStock.setLocation(150,250);
				price.setLocation(150,300);
				netPrice.setLocation(440,350); 
					netPrice.setForeground(Color.RED);
			
			
		//Adding Components to the Container c
		this.setLayout(null);
		c.add(back);
		c.add(viewC);
		c.add(addToC);
		c.add(title);
		
		c.add(lbl1);
		c.add(pCode);
		c.add(lbl2);
		c.add(pName);
		c.add(lbl3);
		c.add(quan);
		c.add(lbl4);
		c.add(inStock);
		c.add(lbl5);
		c.add(price);
		c.add(lbl6);
		c.add(netPrice);
		
		//Setting Frame Properties
		
		this.setTitle("Billing Page");
		this.setSize(700,550);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Adding Listeners to the buttons and other components

		viewC.addActionListener(this);
		addToC.addActionListener(this);
		back.addActionListener(this);
		
		pCode.addFocusListener(this);
		quan.addFocusListener(this);
	}
	/*function to set value of medicine name and other details from table
		it accepts 3 values
		and does not return any value*/
		
	public void get(String name,int quantity,Double rate)
	{
		pName.setText(name);
		if(quantity<1)
			quantity=0;
		inStock.setText(String.valueOf(quantity));
		price.setText(String.valueOf(rate));
		net=rate;	//value of rate is stored in net double type variable
	}
	
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e)
	{	
		//if focus is lost from quantity choice
		// then control comes here
		
		if(e.getComponent()==quan)
		{
			//if value of price is null then
			// netprice is automaticall set to 0
			if(price.getText().equals(""))
				netPrice.setText("0");
			else
			{
				int q=Integer.parseInt(quan.getSelectedItem());
				if(!(inStock.getText().equals("")))
				{
					int is=Integer.parseInt(inStock.getText());
					is=is-q;
					if(is<1)
						is=0;
					inStock.setText(String.valueOf(is));
				}
				/* total double type variable is 
				used to store number of
				 items to be purchased by 
				 the customer	*/
				Double total=Double.parseDouble(quan.getSelectedItem());
				
				/* pric double type variable is
				used to calculate total value
				from rate and number of items
				that is quantity
				double type net variable already contains
				price value */
				
				Double pric=total*net;
				
				//ceil method of math class is used
				//to cut extra numbers after decimal place
				
				pric=Math.ceil(pric);
				
				//pr variable is used to convert double
				//type variable pric into string type
				//as textfield accept string 
				
				String pr=String.valueOf(pric);
				netPrice.setText(pr);
			}
		}
		else if(e.getComponent()==pCode)
		{
			String s=pCode.getText();
			s=s.trim();
			s=s.toUpperCase();
			
			if(s.equals(""))
				JOptionPane.showMessageDialog(this,"Invalid product code");
			else
			{
				pCode.setText(s);
				
				SearchStock ss=new SearchStock();
				
				/* searchstock class object ss is
				created then a string type variable
				bill is used that contains "bill" as value
				this particular bill variable
				is used to distinguish easily 
				for searchstock class that it's 
				object is created for billing page or 
				stock handler page code is also
				concated with the variable bill then
				passes to search method*/
				
				String bill="bill";	//to distinguish between billing page search and stockhandler page search
				
				bill=bill+s;
				boolean b=ss.Search(bill);
				
				if(b==false)
				{
					JOptionPane.showMessageDialog(this,"Product code not found");
					String nam="NULL";
					String stk="NULL";
					String mrp="NULL";
					String tot="NULL";
				
					pName.setText(nam);
					inStock.setText(stk);
					price.setText(mrp);
					netPrice.setText(tot);
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==back)
			{
				/* this class
				is used to truncate temporary
				table of insert
				cart so that another bill is easily
				created without any error */
				
				Updatequant uq=new Updatequant();
				uq.trunc();
				
				//LoginPage p=new LoginPage();
				if(Medical.active.equals("LoginPage"))
				{
					LoginPage p=new LoginPage();
					p.showFrame();
				}	
				else if(Medical.active.equals("MainMenu"))
				{
					new MainMenu();
				}
				
				dispose();
				//p.showFrame();
			}
			else if(e.getSource()==viewC)
			{
				CartPage p=new CartPage();
				
				/* get method of cartpage class
				accepts int type variable row
				that contains how many records
				has been inserted to the insertcart table*/
				
				p.get(row);
				p.showFrame();
				dispose();
			}
			else if(e.getSource()==addToC)
			{
				String nam=pName.getText();
				
				if(nam.equals("")||nam.equals("NULL"))
				{
					JOptionPane.showMessageDialog(this,"No Product to Add to Cart");
					quan.select(0);
				}
				else
				{
					//----------------- Code for adding to cart table goes here ---------
					String pc=pCode.getText();
					String n=pName.getText();
					String q=quan.getSelectedItem();
					
					//pr variable is used to store actual rate
					String pr=price.getText();
				
				//netprice variable is used to store 
				// total price after multiplication with quantity
					String ne=netPrice.getText();
					
					int qu=Integer.parseInt(q);
					int left=Integer.parseInt(inStock.getText());
					
					/* if quantity contains 0 items then it is
					mandatory for customer to select atleast one value
					and if left in stock is less than required amount
					then also adding to cart is not possible*/
					
					if(q.equals("0"))
						JOptionPane.showMessageDialog(this,"Please select atleast 1 quantity");
					else if(left<qu||left<1)
						JOptionPane.showMessageDialog(this," Stock is insufficient"); 
					else
					{
						Insertcart ic=new Insertcart();
						
						//passing values to insert method of
						//insert cart table that accepts 5 string type
						//variables
						
						ic.insert(pc,n,q,pr,ne);
						
						//after inserting row integer type
						//variable is incremented so that
						//row should be counted 
						
						row++;	
						//------------------------------------------------------------------
						JOptionPane.showMessageDialog(this,"Added to Cart.");
						quan.select(0);
						pCode.setText("");
						pName.setText("");
						price.setText("");
						netPrice.setText("");
						inStock.setText("");
					}
				}
				
			}
	}
}
