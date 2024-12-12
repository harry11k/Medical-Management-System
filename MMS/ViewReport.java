import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class ViewReport 
{ 
	public int getrow()
	{
		int row=0;
		try
		{	
			connect cn=new connect();
			Connection con =cn.aconnect();
			
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from MedicalReport");
			while(rs.next())
				row++;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return row;
	}
	
	/* this function  */
	
	public String[][] views()
	{
			int row=getrow();
			String arr[][]=new String [row][6];
			try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from MedicalReport");
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