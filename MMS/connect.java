import java.sql.Connection;
import java.sql.DriverManager;

public class connect
{
	static Connection con;	//used form storing connection path in a variable

	/*	aconnect method is used to provide path to
	// connect java with oracle
	// this method returns Connetion and 
	// this not accept any value*/
	public Connection aconnect()	
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
