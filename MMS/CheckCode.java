import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// this class is used to check whether code is 
// already existing or not
class CheckCode
{
	public boolean Check(String scode)
	{
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
		
			PreparedStatement stmt=con.prepareStatement("select * from StockTable where code=?");
			stmt.setString(1,scode);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
				return true;
		
		}
		catch(Exception et)
		{
			System.out.println(et);
		}
		return false;
	}
}