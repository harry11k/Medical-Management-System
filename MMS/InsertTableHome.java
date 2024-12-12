import java.sql.Connection;
import java.sql.PreparedStatement;

//class to insert report record in table

class InsertTableHome 
{
	/*Home funtion is used to accept value from text box
	of generate report window
	here Sring s1 is used to accept value of name
	int n is used to accept value of age
	String s2 is used to accept value of sex choice
	String s3 is used to accept value of type that is problem
	*/
	
	public boolean Home(String s1,int n,String s2,String s3)//default constructor to insert record in table
	{
				
		try
		{	
			//connect class is used to
			//connect java with oracle
			connect cn=new connect();
			
			//acconect method is defined in connect class
			//that contains driver path and other necessary details
			Connection con =cn.aconnect();
			PreparedStatement stmt=con.prepareStatement("Insert into ReportTable values(?,?,?,?)");
			//prepared statement used to execute query to insert record in reporttable
			
			stmt.setString(1,s1);		
			//used to set value of name in table
			
			stmt.setInt(2,n);
			//used to set value of age in table
			
			stmt.setString(3,s2);
			//used to set value of sex in table
			
			stmt.setString(4,s3);
			//used to set value of problem in table
			
			int rs=stmt.executeUpdate();
			//rs variable is used to check whether record is successfully inserted or not
			if(rs==1)
				return true;
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}

