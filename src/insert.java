import java.sql.*;
import java.util.Scanner;

public class insert {
	private static String TABLE_NAME = "";
	private static String COL_NAME = "";
	private static String COL_VALUE = "";
	
	public static void insertDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			Statement state = conn.createStatement();
			
			// 테이블 이름 받기
			System.out.println("Insert the table name : ");
			TABLE_NAME = scan.nextLine();
			System.out.println("Insert the column name : ");
			COL_NAME = scan.nextLine();
			System.out.println("Insert the column value : ");
			COL_VALUE = scan.nextLine();

			 
			String sql = "insert into "+TABLE_NAME+" ("+COL_NAME+") VALUES(?,?,?,?)";
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setString(1, COL_VALUE.split(",")[0]);
			pstate.setString(2, COL_VALUE.split(",")[1]);
			pstate.setString(3, COL_VALUE.split(",")[2]);
			pstate.setString(4, COL_VALUE.split(",")[3]);
			pstate.executeUpdate();
			
			
			//String sql = "insert into "+TABLE_NAME+" ("+COL_NAME+") VALUES("+COL_VALUE+")";
				
			System.out.println("insert succeed");
			
			//state.executeUpdate(sql);
			
//			while(rs.next()) {
//				String id = rs.getString("id");
//				String course_id = rs.getString("course_id");
//				String student_id = rs.getString("student_id");
//				String grade = rs.getString("grade");
//				System.out.println("\n----------\nID:"+id+"\ncourse_ide"+course_id+"\nstudent_id"+student_id+"\ngrade"+grade);
//			}
			//rs.close();
			state.close();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
	}

}
