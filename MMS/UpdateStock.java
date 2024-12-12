import java.sql.Connection;
import java.sql.PreparedStatement;

/* updatestock class is used to update
the record of stocktable
after searching operation and user press modify button
*/

class UpdateStock
{
	/* upstock method is used to update record
	of stock table
	it accepts 6 values that is code,name
	quantity,rate,mrp,exp */
	
	public boolean upstock(String c,String n,String q,String r,String m,String e)
	{
	
			try
			{
				connect cn=new connect();
				Connection con =cn.aconnect();
				
				PreparedStatement stmt=con.prepareStatement("update StockTable set code=?,name=?,quant=?,rate=?,mrp=?,exp=?where code=?");
				stmt.setString(1,c);
				stmt.setString(2,n);
				stmt.setString(3,q);
				stmt.setString(4,r);
				stmt.setString(5,m);
				stmt.setString(6,e);
				stmt.setString(7,c);
				int rn=stmt.executeUpdate();
				if(rn==1)
					return true;
			}
			catch(Exception exx)
			{
				System.out.println(exx);
			}
			return false;
		}
}
