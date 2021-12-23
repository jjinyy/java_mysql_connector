import java.sql.*;
import java.util.Scanner;

public class drop {
	private static String TABLE_NAME = "";
	private static String DROP_SIGN = "";
	
	public static void dropDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			Statement state = conn.createStatement();
			
			// 테이블 이름 받기
			System.out.println("Insert the table name : ");
			TABLE_NAME = scan.nextLine();
			System.out.println("Are you Sure(Y:yes, N:No)? : ");
			DROP_SIGN = scan.nextLine();
			if(DROP_SIGN.contains("Y") || DROP_SIGN.contains("y")) {
				String sql = "drop table "+TABLE_NAME;
				System.out.println(sql);
				state.executeUpdate(sql);
			}
			
			
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
