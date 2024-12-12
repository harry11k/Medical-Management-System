/* validate stock class is used to validate
all fields in stock class while inputing in
textfield after pressing add record button
a valid method is defined in this class that 
accepts 4 values and return 1 boolean type
variable */

class ValidateStock
{
	public boolean valid(String name,String quant,String rate,String mrp)
	{
		boolean b=true;
		name=name.trim();
		//name=name.toUpperCase();
		
		/* validity of name is based on 
		name must contain alphabets
		its length should be between 3 and 19	*/
		
		if(name.length()>40 ||name.length()<3 || name.equals("") )
		{	
			b=false;
			System.out.println("Symbols allowed in Product name and length range is 3-40");
		}
		
		/* quantity length must be between 1 and 4 and must contain 
		only numeric value and don't contain null values */
		
		if(quant.length()<1 || quant.equals("") || quant.length()>4)
			b=false;
		else
		{
			for(int i=0;i<quant.length();i++)
			{	
				if(quant.charAt(i)<'0'|| quant.charAt(i)>'9')
				{
					b=false;
					break;
				}
			}
		}	
		
		boolean ch=check(rate);
		if(ch==false)
			b=false;
		
		boolean cha=check(mrp);
		if (cha==false)
			b=false;
			
		if(b!=false)
		{
			Double r=Double.parseDouble(rate);
			Double m=Double.parseDouble(mrp);
			if(r>m)
				b=false;
		}
		return b;
	}
	
	public boolean check(String r)
	{
		boolean b=true;
		if(r.length()<1 || r.equals("") || r.length()>7)
			b=false;
		else	
		{
			for(int i=0;i<r.length();i++)
			{
				if(r.charAt(i)<'0' || r.charAt(i)>'9')
				{
					int na=(int)r.charAt(i);
					if(na==46)			//46 is ascii value of dot
						b=true;
					else
					{
						b=false;
						break;
					}
				}	
			}
			
		}
	
		return b;
	}
}
