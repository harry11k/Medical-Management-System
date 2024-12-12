import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class viewcart 
{ 
	static Double total=0.0;
	public String[][] view(String arr[][],int row)
	{	
		try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from InsertCart");
				int c=0;
				
				while(rs.next())
				{
					arr[c][0]=rs.getString(1);
					arr[c][1]=rs.getString(2);
					arr[c][2]=rs.getString(3);
					arr[c][3]=rs.getString(4);
					arr[c][4]=rs.getString(5);
					
					total=total+Double.parseDouble(arr[c][4]);
					
					c++;
				}
				
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			return arr;
	}
}
