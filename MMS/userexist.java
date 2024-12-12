import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class userexist
{
		public boolean user(String s)
		{
			boolean b=false;
				try
				{
					connect cn=new connect();
					Connection con =cn.aconnect();
					
					PreparedStatement stmt=con.prepareStatement("select * from SignUpTable where userid=?");
					stmt.setString(1,s);
					ResultSet n=stmt.executeQuery();
					if(n.next())
					{
						b=true;
						
					}
					else 
						b=false;
				}		
				catch(Exception ec)
				{
					System.out.println(ec);
				}
			return b;
		}
}