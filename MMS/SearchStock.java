import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//class to search stock
class SearchStock
{
	public boolean Search(String code)
	{
		String billing=code;
		if(code.length()>4)
			if(code.substring(0,4).equals("bill"))
				code=code.substring(4,code.length());
		String name2="";
		int qu=0;
		double rat=0.0;
		double mrp2=0.0;
		String exp3="";
		boolean ba=false;
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			PreparedStatement stmt=con.prepareStatement("Select * from StockTable where code=?");
			String r=code;
			stmt.setString(1,r);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				 ba=true;
				  
				name2=rs.getString(2);
				qu=rs.getInt(3);
				rat=rs.getDouble(4);
				mrp2=rs.getDouble(5);
				exp3=rs.getString(6);
			}
			else
				System.out.println("Record is not found");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			if(billing.equals(code))
			{
				StockHandlerPage sp=new StockHandlerPage();
				sp.get(name2,qu,rat,mrp2,exp3);
			}
			else
			{
				BillingPage bp=new BillingPage();
				bp.get(name2,qu,rat);
			}
			
		return ba;
	}
}
