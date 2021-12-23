import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class select {
	private static String TABLE_NAME = "";
	private static String COL_NAME = "";
	private static String COL_ORDER = "";
	private static String SORT_CASE = "";
	
	public static void selectDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			Statement state = conn.createStatement();
			
			// 테이블 이름 받기
			System.out.println("Insert the table name : ");
			TABLE_NAME = scan.nextLine();
			System.out.println("Insert the column name(ALL : *) : ");
			COL_NAME = scan.nextLine();
			System.out.println("Insert the columns name for ordering(press enter the skip) : ");
			COL_ORDER = scan.nextLine();
			System.out.println("Insert the sorting criteria(press enter the skip) : ");
			SORT_CASE = scan.nextLine();

			  
			String sql = "select "+COL_NAME+" FROM "+TABLE_NAME+" ORDER BY "+COL_ORDER+" "+SORT_CASE;
				
			System.out.println(sql);
			ResultSet rs = state.executeQuery(sql);
			java.sql.ResultSetMetaData metaData = rs.getMetaData();
			int cnt = metaData.getColumnCount();
			String str = "";

			for (int i = 1; i<=cnt;i++) {
				str +=metaData.getColumnName(i)+"|";
			}
			System.out.println("\n===========================\n");
			System.out.println(str);
			System.out.println("\n===========================\n");
//			str += "\n";
//			System.out.println(str);
			
			String PrintCol = "";
			
			while(rs.next()) {
				for(int i = 1; i<=cnt;i++) {
					String col = rs.getString(metaData.getColumnName(i));
					PrintCol += col+"\t";
				}
				System.out.println(PrintCol);	
				PrintCol = "";
			}

			System.out.println("\n===========================\n");
				
//				String id = rs.getString(metaData.getColumnName(i));
//				String course_id = rs.getString("course_id");
//				String student_id = rs.getString("student_id");
//				String grade = rs.getString("grade");
//				System.out.println("===========");
//				
//				java.sql.ResultSetMetaData metaData = rs.getMetaData();
//				int cnt = metaData.getColumnCount();
//				String str = metaData.getColumnName(1);
//				System.out.println(str);
//				for (int i = 2; i<=cnt;i++) {
//					str +="\t"+metaData.getColumnName(i);
//				}
//				str += "\n";
//				System.out.println(str);
////				System.out.println("\n----------\nID|course_id|student_id|grade"+id+"\ncourse_id"+course_id+"\nstudent_id"+student_id+"\ngrade"+grade);
////				System.out.println(id+"|"+course_id+"|"+student_id+"|"+grade);
////			}
			rs.close();
			state.close();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
	}

}
