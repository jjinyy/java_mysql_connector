import java.sql.*;
import java.util.Scanner;

public class create {
	private static String TABLE_NAME = "";
	private static String[] COL_NAME = new String[10];
	private static String[] COL_DATATYPE = new String[10];
	private static String[] COL_CK_PRIMARYKEY = new String[10];
	private static String[] COL_CK_NULL = new String[10];
	private static String COL_PRIMARYKEY = "";
	
	public static void createDB(Connection conn) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			Statement state = conn.createStatement();
			
			// 테이블 이름 받기
			System.out.println("Insert the table name : ");
			TABLE_NAME = scan.nextLine();

			  int idx = 0;
			  
			  // 변수에 값 넣기
			  do{
				   //컬럼이름 입력
				   System.out.print("Insert the Colums name(press enter to finish):");
				   COL_NAME[idx] = scan.nextLine();
				   if (COL_NAME[idx].equals("")) 
			       {
				    break;
				   }
				   System.out.print(COL_NAME[idx] + "\n");
				   
				   // 컬럼 타입 입력
				   System.out.print("Insert the columns type:");
				   COL_DATATYPE[idx] = scan.nextLine();
				   System.out.print(COL_DATATYPE[idx]+ "\n");
				   
				   // 프라이머리 키 유무
				   System.out.print("Insert the columns condition(1: primary key, 2: skip)");
				   COL_CK_PRIMARYKEY[idx] = scan.nextLine();
				   if (COL_CK_PRIMARYKEY[idx].equals("1")) {
					   COL_PRIMARYKEY = COL_PRIMARYKEY + COL_NAME[idx] + ",";
				   }
				   System.out.print(COL_CK_PRIMARYKEY[idx]+ "\n");
				   
				   //NULL 유무
				   System.out.print("Insert the columns condition(1: not null, 2: skip)");
				   COL_CK_NULL[idx] = scan.nextLine();
				   if (COL_CK_NULL[idx].equals("1")) {
					   COL_CK_NULL[idx] = "NOT NULL";
				   }else if(COL_CK_NULL[idx].equals("2")) {
					   COL_CK_NULL[idx] = "";
				   }
				   System.out.print(COL_CK_NULL[idx]+ "\n");
				   
				   idx += 1;
			   
				  }while(true);
			
			  if(COL_PRIMARYKEY != "") {
				  COL_PRIMARYKEY = COL_PRIMARYKEY.substring(0, COL_PRIMARYKEY.length()-1);  
			  }
			  
			  String sql = "CREATE TABLE "+TABLE_NAME+"("
			  +COL_NAME[0]+" "+COL_DATATYPE[0]+" "+COL_CK_NULL[0]+","
			  +COL_NAME[1]+" "+COL_DATATYPE[1]+" "+COL_CK_NULL[1]+","
			  +COL_NAME[2]+" "+COL_DATATYPE[2]+" "+COL_CK_NULL[2]+","
			  +COL_NAME[3]+" "+COL_DATATYPE[3]+" "+COL_CK_NULL[3]+","
			  +"PRIMARY KEY ("+COL_PRIMARYKEY+"))";
				
			  //System.out.println(sql);
			
			state.executeUpdate(sql);
			
//			while(rs.next()) {
//				String showData = rs.getString("Database");
//				System.out.println(showData);
//			}
			//rs.close();
			state.close();
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
	}

}
