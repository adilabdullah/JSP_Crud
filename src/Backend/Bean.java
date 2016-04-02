package Backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class Bean {
	public static Connection Conn()
	{
		Connection conn=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mis","mis123");
		
	}
	catch(Exception e)
	{
	System.err.println(e);
	}
	return conn;
	}
}
