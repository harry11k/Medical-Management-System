import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//class to check existing user name

// to check user availability that whether
// user is authorized that is login id
// and password exists in table or not
class userchek
{	
	/*check method is used to 
	check whether user is authorized or not
	it accepts two values userid and password
	and returns integer variable
	 it returns 0 if user is unauthorazed
	 it returns 1 if user have only permission
	 to access billing page
	 it returns 2 if user have full permission */
	public int check(String s1,String s2)
	{
		int b=0;
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			Statement stmt=con.createStatement();
			String query="select * from SignUpTable";
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				String uch=rs.getString(4);//variables to access user name from current record
				String pch=rs.getString(7);//variables to access password from current record
				String rg=rs.getString(6);//variables to store right
				if(uch.equals(s1)&&pch.equals(s2)&&rg.length()<15)
				{
					b=1;
					break;
				}
				else if(uch.equals(s1)&&pch.equals(s2)&&rg.length()>16)
				{
					b=2;
					break;
				}
				
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
}
