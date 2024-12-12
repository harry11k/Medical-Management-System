import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/* tablestock class is used to extract number of
records in table and return record in the form
of 2d array */

class Tablestock 
{ 
	
	/* getrow function is used to count number of
	rows in existing table so that array arr is 
	created according to the row
	this function does not accept any value but
	return integer type variable that is number of
	records in the table */
	
	public int getrow()
	{
		int row=0;
		try
		{	
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from StockTable");
			while(rs.next())
				row++;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return row;
	}
	
	/* this function views accepts
	one string type double dimension array
	and also returns a double dimension
	string type variable */
	
	public String[][] views(String arr[][])
	{
			int row=getrow();
			arr=new String [row][6];
			try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from StockTable");
				int c=0;
				while(rs.next())
				{
					arr[c][0]=rs.getString(1);
					arr[c][1]=rs.getString(2);
					arr[c][2]=rs.getString(3);
					arr[c][3]=rs.getString(4);
					arr[c][4]=rs.getString(5);
					arr[c][5]=rs.getString(6);
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
