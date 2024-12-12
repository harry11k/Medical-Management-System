
//Validity class contains all the methods related to verifying the different fields
public class Validity
{
	//all the methods below validiates an Value as per the method's name
	//it returns false if it is not valid else returns true
	
	String myString;
	
	public boolean name(String s)				//NAME
	{
		/*
		length should be more than 2
		and it should not contain any symbol other tha A-Z
		*/
		
		boolean valid=true;
		
		s=s.trim();
		s=s.toUpperCase();
		
		if(s.length()<2 || s.length()>15){
			valid=false;
			System.out.print("Name length is out of range");
			}
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>'Z' || s.charAt(i)<'A')
			{
				valid=false;
				System.out.print("Name has invalid symbol");
				break;
			}
		}
		if(valid==true)
			myString=s;
		
		return valid;
	}
	
	public boolean email(String s)				//email
	{
		boolean valid=true;
		s=s.trim();	
		s=s.toLowerCase();
	
		int count=0;
		//checks if there is no any consecutive occurance of '.' or occurance of '.' invalid position
		if(s.contains("..")==true || s.contains("@.")==true || s.contains(".@")==true )
				valid=false;
		
		if(s.length()>30)
		{
			valid=false;
			System.out.print("length is greater than 30");
		}
		//checks if ends with '.com' and does not start with '.'
		if(s.endsWith(".com") && !(s.startsWith(".")))  
		{
		//limits the character range to a-z,0-9,@,_,-,.	
			for(int i=0;i<s.length();i++)
			{
				if(!(s.charAt(i)>='a' || s.charAt(i)<='z' || s.charAt(i)>='0' || s.charAt(i)<='9' || s.charAt(i)=='-' || s.charAt(i)=='@' ||s.charAt(i)=='.'|| s.charAt(i)=='_'))
				{
						valid=false;
						break;
				}
				else if(s.charAt(i)=='@')
				{
					count++;
					if(count>1)
					{
						valid=false;
						break;
					}
				}
		}	}
		else
		{
			valid=false;
		}
		
		if(count<1)
		valid=false;

		if(valid==true)
			myString=s;
		
		return valid;
	}
	
	public boolean username(String s)				//username
	{
		/*
		contains no space
		and limits characters to only 0-9,A-Z,a-z 
		*/
		
		boolean valid=true;
		s=s.trim();
		
		for(int i=0;i<s.length();i++)
		{
			if(!(s.charAt(i)<='Z' || s.charAt(i)>='A' || s.charAt(i)<='z' || s.charAt(i)>='a' ||s.charAt(i)<='9'||s.charAt(i)>='0'))
			{
				valid=false;
				break;
			}
		}
		if(s.length()<6 || s.length()>30){
		valid=false;
		System.out.println("length of email is greater tha 30");
		}
	
		if(s.equals("superuser")){
			valid=false;
		System.out.println("You don't have right to creat superuser");
		}
		
		if(valid==true)
			myString=s;
	
		return valid;
	}
	
	public boolean authentication(String s)
	{
		s=s.trim();
		if(s.equals("123livewire"))
			return true;
		else 
			return false;
	}
	
	public boolean password(String s,String s1)
	{
		
		if(s.equals(s1) && s.length()>6 && s.length()<=15)
			return true;
		else
			return false;
	}
	
	
	//return the varified string
	public String setVarifiedString()
	{
		return myString;
	}
	
	//checks if there is any empty field or not
	public boolean noEmptyFields(String s1,String s2,String s3,String s4,String s5,String s6,String s7)
	{
		boolean valid=true;
		
		s1=s1.trim();
		s2=s2.trim();
		s3=s3.trim();
		s4=s4.trim();
		s5=s5.trim();
		s6=s6.trim();
		s7=s7.trim();
		
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals(""))
		{
			valid=false;
		}
		
		return valid;
	}
	
}

