
package ec.cjpq.core.util;

import java.sql.*;

/**
 * Community Medical Center module
 * JRDataSourceFactory utility class
 * @author carper
 * 2017-02-09
 */
public class H2Script{
	public static void main(String args[]){
		try{
			Class.forName("org.h2.Driver");

			Connection con=DriverManager.getConnection( "jdbc:h2:tcp://localhost/~/app", "SA", "");

			PreparedStatement stmt=con.prepareStatement("SCRIPT SIMPLE NOSETTINGS");
			//PreparedStatement stmt=con.prepareStatement("SCRIPT SIMPLE NOSETTINGS to '/home/carper/App/web/WEB-INF/h2/data.sql' CHARSET 'UTF-8'");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){

        		String columnValue = rs.getString(1);
				//System.out.println(columnValue);

				if (columnValue.startsWith("INSERT"))
					System.out.println(columnValue);

			}

			con.close();

		}catch(Exception e){ 
			System.out.println(e);
		}

	}
}
