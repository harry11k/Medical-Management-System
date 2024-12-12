import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

//class to insert stock records in the table
class InsertStock 
{
	public boolean Stock(String c,String n,int q,double r,double m,String ex)			//function  to insert record in table
	{
		boolean b=false;
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			Scanner in=new Scanner(System.in);
			PreparedStatement stmt=con.prepareStatement("Insert into StockTable values(?,?,?,?,?,?)");
			stmt.setString(1,c);
			stmt.setString(2,n);
			stmt.setInt(3,q);
			stmt.setDouble(4,r);
			stmt.setDouble(5,m);
			stmt.setString(6,ex);
			int rs=stmt.executeUpdate();
			if(rs==1)
				b=true;
			//con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
}
