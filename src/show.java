import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class show {
    //private String a;
	public static void showDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Statement state = conn.createStatement();
			String sql = "SHOW tables from jdbc";
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				String showData = rs.getString("Tables_in_jdbc");
				System.out.println("===========");
				System.out.println("Table List");
				System.out.println(showData);
				System.out.println("===========");
			}
			rs.close();
			state.close();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
	}

}
