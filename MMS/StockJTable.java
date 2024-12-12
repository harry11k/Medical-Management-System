import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//*************** Stock PAGE ******************************
/*this class is used to show values of stock table
when ever user clicks on view stock radio button in
stockhandler page */

class StockJTable extends JFrame implements ActionListener
{	
	static JButton back;
	static JTable table;
	int row=0;
	static String s[][];
	public void showFrame()
	{
		Container c=this.getContentPane();
		
		//creating header Components
		
		back=new JButton("BACK");
		
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(back,BorderLayout.WEST);
		//Creating Body Components
		
		String head[]={"Code","Name","Quantity","Rate","Mrp","Expiry"};
	
		/* tablestock class object ts is created
		to use method to display record in stock
		getrow method returns number of records
		in the form of integer so that
		jtable row can be adjusted in that format */
		
		Tablestock ts=new Tablestock();
		row=ts.getrow();
		
		/* string s double dimension array object
		is created to 	pass and accept values from
		views method of table stock class */
		s=new String[row][6];
			if(row!=0)
				s=ts.views(s);
			else
				JOptionPane.showMessageDialog(this,"No Product in stock");
		String body[][]=s;
		table=new JTable(body,head);
		this.add(new JScrollPane(table));
			
		//Adding Components to the Container c
		c.add(p1,BorderLayout.NORTH);
		//Setting Frame Properties
		
		this.setTitle("StockJTable");
		this.setSize(700,550);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//Adding Listeners to the buttons and other components

		back.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			dispose();
		}
	}
}
