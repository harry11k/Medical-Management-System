import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

//************Insert cart class is used to
// store value of cart page that is billing page values
class Insertcart 
{
	/* insert method is used to store five values
	accepted by this particular method to the
	table this method returns boolean type variable*/
	
	public boolean insert(String code,String name,String quant,String price,String netprice)			//function  to insert record in table
	{
		boolean b=false;
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			Scanner in=new Scanner(System.in);
			PreparedStatement stmt=con.prepareStatement("Insert into InsertCart values(?,?,?,?,?)");
			stmt.setString(1,code);
			stmt.setString(2,name);
			stmt.setString(3,quant);
			stmt.setString(4,price);
			stmt.setString(5,netprice);
			
			int rs=stmt.executeUpdate();
			if(rs==1)
				b=true;
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
}
