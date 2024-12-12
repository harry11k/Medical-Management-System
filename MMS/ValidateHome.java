//ValidateHome class is used to validate
//values while inserting detils of patient like name ,age etc
	
class ValidateHome 
{
	//valid method is used to validate name and age
	//it returns boolean type variable
	//it accepts two string type variable
	public boolean valid(String name,String age)
	{
		boolean va=true;
		name=name.trim();
		name=name.toUpperCase();
		if(name.length()<3 || name.length()>30)		//set va=false if length of name is less than 3
			va=false;
			
		//this for loop is used to check that 
		// if name variable is containing 
		// only alphabets and space after 
		for(int i=0;i<name.length();i++)
		{
			if(name.charAt(i)>'Z' || name.charAt(i)<'A' )
			{	
				//na variable is used to get ascci value
				//of characted by character to check space
				int na=(int)name.charAt(i);
				if(na==32)			//32 is ascii value of space
					va=true;
				else
				{
					va=false;
					break;
				}
			}
			
		}
		//this for loop is used to check age value
		//should only contains numbers
		if(age.length()>4)
			va=false;
		for(int i=0;i<age.length();i++)
		{
			if(age.charAt(i)<'0'|| age.charAt(i)>'9')
			{
				va =false;
				break;
			}
		}
		return va;
	}

}
