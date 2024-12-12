import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class Updatequant
{
	public void upstock()
	{
		String code="";
		int quantity=0;
		int quant=0;
	
		try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from InsertCart");
				while(rs.next())
				{
					code=rs.getString(1);
					quantity=Integer.parseInt(rs.getString(3));
					
					quant=quantst(code);	
				
					update(code,quant-quantity);
				}
				
			}
			catch(Exception exx)
			{
				System.out.println(exx);
			}
			
	}
	public void update(String code,int left)
	{
		if(left<1)
			left=0;
		code=code.toUpperCase();
		try
		{
		connect cn=new connect();
		Connection con =cn.aconnect();
		
		PreparedStatement stmt=con.prepareStatement("update StockTable set quant=? where code=?");
		stmt.setInt(1,left);
		stmt.setString(2,code);
		int rn=stmt.executeUpdate();
		if(rn==1)
			System.out.println("Successfully updated");
		else
			System.out.println("Error");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void trunc()
	{
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			Statement stmt=con.createStatement();
			stmt.execute("truncate table InsertCart");
			System.out.println("success");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int quantst(String code)
	{	
		code=code.toLowerCase();
		int q=0;
			try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				PreparedStatement stmta=con.prepareStatement("Select * from StockTable where code=?");
				stmta.setString(1,code);
				ResultSet rsa=stmta.executeQuery();
					
				if(rsa.next())
					q=rsa.getInt(3);
						
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return q;
	}
	
}