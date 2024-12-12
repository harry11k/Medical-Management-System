import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

// class to insert record in signup page
class InsertSignUp
{
	/*InsertUser function is used to
	insert value of SignUpTable in sql
		this function accepts 7 value and doesnot
			return any value*/
	
	public void InsertUser(String s1,String s2,String s3,String s4,String s5,String ra,String s7)
	{
		try
		{
		
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			//Scanner in=new Scanner(System.in);
			PreparedStatement stmt=con.prepareStatement("insert into SignUpTable values(?,?,?,?,?,?,?)");
			stmt.setString(1,s1);
			stmt.setString(2,s2);
			stmt.setString(3,s3);
			stmt.setString(4,s4);
			stmt.setString(5,s5);
			stmt.setString(6,ra);
			stmt.setString(7,s7);
			int r=stmt.executeUpdate();
			
			if(r==1)
				System.out.println(r+"Success");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
