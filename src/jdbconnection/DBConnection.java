package jdbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: Subramaniam S
 * Date: 9/2/13
 * Time: 3:34 PM
 */
public class DBConnection
{
	public static void newDBConnection(String serverIp, int portno, String userName, String password, String instance, String driver)
	{
		String dbType = "Oracle";
		String url = "";

		Connection conn = null;
		Statement stmt = null;
		try
		{
				if(dbType.equals("Oracle"))
				{
					url= "jdbc:oracle:thin:@"+serverIp+":"+portno+":"+instance;
					try
					{
						if(driver != null)
							Class.forName(driver).newInstance();
						if(userName!=null && password!=null)
							conn=DriverManager.getConnection(url, userName, password);
						else
							conn=DriverManager.getConnection(url);
						stmt=conn.createStatement();
						System.out.println("Connection Established...");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn!=null)
			{
				try
				{
					conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args)
	{
		newDBConnection(args[0],Integer.parseInt(args[1]),args[2],args[3],args[4],args[5]);
	}
}
