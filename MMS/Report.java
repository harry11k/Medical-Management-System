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

class Report extends JFrame implements ActionListener
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
		
		String head[]={"Code","Name","Quantity","MRP","Price","Date","Total"};
	
		/* tablestock class object ts is created
		to use method to display record in stock
		getrow method returns number of records
		in the form of integer so that
		jtable row can be adjusted in that format */
		
		ViewReport ts=new ViewReport();
		row=ts.getrow();
		
		/* string s double dimension array object
		is created to 	pass and accept values from
		views method of ViewReport class */
		s=new String[row][6];
			if(row!=0)
				s=ts.views();
			else
				JOptionPane.showMessageDialog(this,"No purchase is done");
		
		double total=0.0;
		String tab[][]=new String[row][7];
		String date="",da="";
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<6;j++)
				tab[i][j]=s[i][j];
			
			date=s[i][5];
			double t=Double.parseDouble(tab[i][4]);
			total+=t;
					
			if(i!=0)
			{
				if(da.equals(date))
					tab[i][6]="";
				else
				{
					double tr=total-t;
					tab[i-1][6]=String.valueOf(tr);
					total=t;
				}
			}
			da=date;
			if(i==row-1)
				tab[i][6]=String.valueOf(total);
	
		}
		
		String body[][]=tab;
		table=new JTable(body,head);
		this.add(new JScrollPane(table));
			
		//Adding Components to the Container c
		c.add(p1,BorderLayout.NORTH);
		//Setting Frame Properties
		
		this.setTitle("MedicineReport");
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
			//new MainMenu();
			//p.showFrame();
			dispose();
		}
	}
}
