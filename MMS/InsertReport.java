import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class InsertReport 
{
	
	public void pass(String arr[][],int row)
	{
		for(int i=0;i<row;i++)
		{
			boolean b=Report(arr[i][0],arr[i][1],arr[i][2],arr[i][3],arr[i][4],arr[i][5]);
			//System.out.println(b);
		}
	}
	public boolean Report(String code,String name,String quantity,String mrp,String  price,String mdate)			//function  to insert record in table
	{
		boolean b=false;
		try
		{
			connect cn=new connect();
			Connection con =cn.aconnect();
			Scanner in=new Scanner(System.in);
			PreparedStatement stmt=con.prepareStatement("Insert into MedicalReport values(?,?,?,?,?,?)");
			stmt.setString(1,code);
			stmt.setString(2,name);
			stmt.setString(3,quantity);
			stmt.setString(4,mrp);
			stmt.setString(5,price);
			stmt.setString(6,mdate);
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
