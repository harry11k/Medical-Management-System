import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//********************** MainMenu Page *****************

class MainMenu extends JFrame implements ActionListener
{
	JMenuItem a1,a2, b1,b2,b3,b4,b5,c1,d1,d2,e1;
	
	public MainMenu()
	{
		Medical.active="MainMenu";
		//working with menubar
		
		JMenuBar bar=new JMenuBar();
		JMenu m1=new JMenu("User");
		JMenu m2=new JMenu("Manage");
		JMenu m3=new JMenu("Billing");
		JMenu m4=new JMenu("Records");
		JMenu m5=new JMenu("Help");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		bar.add(m5);
		
		 a1=new JMenuItem("New Signup");
		 a2=new JMenuItem("Login As Different user");
		
		 b1=new JMenuItem("Search");
		 b2=new JMenuItem("Add");
		 b3=new JMenuItem("Modify");
		 b4=new JMenuItem("Delete");
		 b5=new JMenuItem("View Records as Table");
		
		 c1=new JMenuItem("Billing Page");
		
		 d1=new JMenuItem("Generate Patient Record");
		 d2=new JMenuItem("Invoice Report");
		
		 e1=new JMenuItem("About Medical Management System");
		
		
		a1.setToolTipText("Create an Account for a new User");
		a2.setToolTipText("Re-Login as a different user");
		b1.setToolTipText("Search the Medicines in stock by their poduct code");
		b2.setToolTipText("Add new Medicines to the stock");
		b3.setToolTipText("Update a Product Record");
		b4.setToolTipText("Delete Existing Record from the stock");
		b5.setToolTipText("View the Medicines in stock as TABLE");
		c1.setToolTipText("Jump to Billing Page");
		d1.setToolTipText("Add a new Patient");
		d2.setToolTipText("View the Sales Report as Table");
		e1.setToolTipText("About Medical Management System");
		
		
		m1.add(a1);
		m1.add(a2);
		m2.add(b1);
		m2.add(b2);
		m2.add(b3);
		m2.add(b4);
		m2.add(b5);
		m3.add(c1);
		m4.add(d1);
		m4.add(d2);
		m5.add(e1);
		
		
		// working with rest of the frame
		setLayout(null);
		JLabel l=new JLabel();
		l.setIcon(new ImageIcon("images\\menu.jpg"));
		l.setSize(800,500);
		l.setLocation(0,-15);
		
		//----------------- adding components to frame--------
		
		add(l);
		
		//----------------Setting up frame properties----------------
		
		this.setJMenuBar(bar);
		this.setTitle("Main Menu");
		this.setVisible(true);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		//-------------- adding listener -------------------------
		a1.addActionListener(this);
		a2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		c1.addActionListener(this);
		d1.addActionListener(this);
		d2.addActionListener(this);
		e1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==a1)
		{
			SignupPage p=new SignupPage();
			p.showFrame();
			dispose();
		}
		else if(e.getSource()==a2)
		{
			LoginPage p=new LoginPage();
			p.showFrame();
			dispose();
		}
		else if(e.getSource()==b1)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			p.del.setSelected(true);
			JOptionPane.showMessageDialog(this,"Search the Record to be deleted");
			dispose();
		}
		else if(e.getSource()==b2)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			p.add.setSelected(true);
			dispose();
		}
		else if(e.getSource()==b3)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			p.del.setSelected(true);
			JOptionPane.showMessageDialog(this,"Search the Record to be Modified");
			dispose();
		}
		else if(e.getSource()==b4)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			p.del.setSelected(true);
			JOptionPane.showMessageDialog(this,"Search the Record to be Deleted");
			dispose();
		}
		else if(e.getSource()==b5)
		{
			StockHandlerPage p=new StockHandlerPage();
			p.showFrame();
			p.view.setSelected(true);		
			dispose();
		}
		else if(e.getSource()==c1)
		{
			BillingPage p=new BillingPage();
			p.showFrame();
			dispose();
		}			
		else if(e.getSource()==d1)
		{
			ReportPage p=new ReportPage();
			p.showFrame();
		
		}
		else if(e.getSource()==d2)
		{
			Report r=new Report();
			r.showFrame();
		}
		else if(e.getSource()==e1)
		{
			AboutPage p=new AboutPage();
			p.showFrame();
		}
		
	}
	
	
}
