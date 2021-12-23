import java.sql.*;
import java.util.Scanner;

public class update {
	private static String TABLE_NAME = "";
	private static String COL_NAME = "";
	private static String CONDITION = "";
	private static String COL_VALUE = "";
	private static String DESIRED_COL = "";
	private static String DESIRED_VALUE = "";
	
	public static void updateDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			Statement state = conn.createStatement();
			
			// 테이블 이름 받기
			System.out.println("Insert the table name : ");
			TABLE_NAME = scan.nextLine();
			System.out.println("Insert the condition column name : ");
			COL_NAME = scan.nextLine();
			System.out.println("Insert the condition(1:=, 2:>, 3:<, 4:>=, 5:<=, 6!=     ) : ");
			CONDITION = scan.nextLine();
			if(CONDITION == "1") {
				CONDITION = "=";
			}else if(CONDITION == "2") {
				CONDITION = ">";
			}else if(CONDITION == "3") {
				CONDITION = "<";
			}else if(CONDITION == "4") {
				CONDITION = ">=";
			}else if(CONDITION == "5") {
				CONDITION = "<=";
			}else if(CONDITION == "6") {
				CONDITION = "!=";
			}
			System.out.println("Insert the condition value : ");
			COL_VALUE = scan.nextLine();
			System.out.println("Insert the desired column : ");
			DESIRED_COL = scan.nextLine();
			System.out.println("Insert the desired value : ");
			DESIRED_VALUE = scan.nextLine();

			  
			  String sql = "update "+TABLE_NAME+" SET "+COL_NAME+"="+COL_VALUE +" WHERE "+DESIRED_COL+CONDITION+DESIRED_VALUE;
				
			  System.out.println(sql);
			
			state.executeUpdate(sql);
			
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
