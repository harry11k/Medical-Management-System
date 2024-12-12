import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

//class to delete stock records in the table
class DeleteStock
{
	public  boolean Delete(String code)			//function  to insert record in table
	{
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
		
			Scanner in=new Scanner(System.in);
			PreparedStatement stmt=con.prepareStatement("delete from StockTable where code=?");
			String r=code;
			stmt.setString(1,r);
			int rs=stmt.executeUpdate();
			if(rs==1)
				return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
