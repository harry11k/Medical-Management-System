import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//*************** CART PAGE ******************************
class CartPage extends JFrame implements ActionListener
{	
	static JButton back,print;
	static JTextField total;
	static JTable tabl;
	static String code,name,quant,mrp,price;
	String s[][];
	int row=0;
	static Double tot=0.0;
	public void get(int r)
	{
		row=r;
	}
	public void showFrame()
	{
		Container c=this.getContentPane();
		
		//creating header Components
		JLabel title=new JLabel("CART");
		JPanel p0=new JPanel();
		p0.add(title);
		
		title.setFont(new Font("Times New Roman",Font.BOLD,20));
		back=new JButton("BACK");
		
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(back,BorderLayout.WEST);
		p1.add(p0,BorderLayout.CENTER);
		
		//creating footer Components
		
		print=new JButton("Print/Buy");
		JLabel lbl=new JLabel("TOTAL = ");
		total=new JTextField(15);
		total.setEditable(false);
		JPanel p2=new JPanel();
		p2.add(lbl);
		p2.add(total);
		p2.add(print);
		
		//Creating Body Components
		String head[]={"Product Code","Product Name","Quantity","MRP","Price"};
	
		int ro=row-1;
		s=new String[row][5];
		//String arr=new String[row][5];
		viewcart vc=new viewcart();
		if(row>0)
			s=vc.view(s,row);
		else
			JOptionPane.showMessageDialog(this,"No Product in cart");
		
		tot=0.0;
		//System.out.println("value in total"+tot);
		//System.out.println("value of row="+row);
		for(int r=0;r<row;r++)
		{
			String sr=s[r][4];
			if(sr.equals("null"))
				tot=0.0;
			else
			{
				//System.out.println("value"+s[r][4]);
				tot+=Double.parseDouble(sr);
				//System.out.println("Total"+tot);
			}
		}
		total.setText(String.valueOf(tot));
		
		String body[][]=s;
		
		tabl=new JTable(body,head);
		this.add(new JScrollPane(tabl));
			
		//Adding Components to the Container c
		c.add(p1,BorderLayout.NORTH);
		c.add(p2,BorderLayout.SOUTH);
		//Setting Frame Properties
		
		this.setTitle("Cart");
		this.setSize(700,550);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Adding Listeners to the buttons and other components

		back.addActionListener(this);
		print.addActionListener(this);
	}
	public String date()
	{
		Calendar c=Calendar.getInstance();
		
		int d=c.get(Calendar.DATE);
		int m=c.get(Calendar.MONTH)+1;
		int y=c.get(Calendar.YEAR);
		
		String da;
		if(d<10)
		{
			String s="0";
			da=String.valueOf(d);
			da=s+da;
		}
		else
			 da=String.valueOf(d);
		
		String mon;
		if(m<10)
		{
			String mo="0";
			mon=String.valueOf(m);
			mon=mo+mon;
		}
		else
			mon=String.valueOf(m);
		String dat=da+"-"+mon+"-"+String.valueOf(y);
		return dat;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			BillingPage p=new BillingPage();
			p.showFrame();
			dispose();
		}
		else if(e.getSource()==print)
		{

			if(row<1)
				JOptionPane.showMessageDialog(this,"No Product Available");
			else
			{	
				JOptionPane.showMessageDialog(this,"Purchase Successfull.");
				Updatequant uq=new Updatequant();
				uq.upstock();
				uq.trunc();
			
				String report[][]=new String[row][6];
			
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<5;j++)
					{
						report[i][j]=s[i][j];
						//System.out.println(report[i][j]);
					}
					report[i][5]=date();
					//System.out.println(report[i][5]);
				
				}
			
				InsertReport ir=new InsertReport();
				ir.pass(report,row);
			
				dispose();
				new MainMenu();
			}	//p.showFrame();
		}
	}

}