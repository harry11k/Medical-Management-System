/*
Medical Store Management System
Admin: superuser
password: nkk50kkk
authentication number: ncBCA201417
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
/* to create table in sql
	user the file Table.lst which can be found in the same directory as the Medical.java file

	@D:\Project\Table.lst;
	path may change according to 
	availability of Table.lst file in your computer*/


public class Medical
{
	static public String active="Medical"; //it contains the name of last active frame for getting back to it
	
	public static void main(String args[])
	{
		Updatequant uq=new Updatequant();
		uq.trunc();
		
		WelcomePage w=new WelcomePage();
		w.showFrame();
		
	}
}

//************** Misc Classes **************************


// class connect is used to connect java
// with oracle by giving driver path and oracle
// id and password according to currend userid
// and password change the userid and password 
// and also path if required



















