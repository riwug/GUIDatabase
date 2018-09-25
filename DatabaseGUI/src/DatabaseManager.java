import java.sql.*;

public class DatabaseManager {
	
	Connection conn;
	
	public DatabaseManager() {
		System.out.println("DatabaseManager instantiated.");
		
		try {
	    // create a mysql database connection	
		//String myDriver = "org.gjt.mm.mysql.Driver";
		String myDriver = "com.mysql.cj.jdbc.Driver";
	      
	    //Get Connection
	    String myUrl = "jdbc:mysql://127.0.0.1:8889/nameTelDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    Class.forName(myDriver);

	    try {
	    	conn = DriverManager.getConnection(myUrl, "root", "root");
	    } catch (Exception e) { e.printStackTrace(); }
	         
	    // the mysql insert statement
	    String query = " insert into teldata (first_name, last_name, telephone)"
	    	+ " values (?, ?, ?)";

	    // create the mysql insert preparedstatement
	    PreparedStatement preparedStmt = conn.prepareStatement(query);
	    preparedStmt.setString (1, "Fanta");
	    preparedStmt.setString (2, "Trinker");
	    preparedStmt.setString   (3, "1234");
	      
	    // execute the preparedstatement
	    preparedStmt.execute();
	    conn.close();
	    }
	    catch (Exception e) {
	    	System.err.println("Got an exception!");
	    	System.err.println(e.getMessage());
	    	e.printStackTrace();
	    }
	}	
}
