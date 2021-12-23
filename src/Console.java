import java.util.Scanner;
import java.sql.*;

public class Console {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
	private static String USER_NAME = "";
	private static String PASSWORD = "";
	private static int NUM = 0;


	public static void main(String[] args) {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("connect the database...");
			Scanner scan = new Scanner(System.in);
			System.out.println("USER NAME:");
			USER_NAME = scan.nextLine();
			System.out.println("PASSWORD");
			PASSWORD = scan.nextLine();
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connection successful!");
			//Control();
			System.out.println("please input the instruction number(1:Show, 2:Create, 3:Select, 4:Insert ,5:Delete, 6:Update, 7:Drop Table, 8:Exit):");
			NUM = scan.nextInt();

			if (NUM == 1) {
				show sh = new show();
				sh.showDB(conn);
			}else if(NUM == 2) {
				create cr = new create();
				cr.createDB(conn);
			}else if(NUM == 3) {
				select sel = new select();
				sel.selectDB(conn);
			}else if(NUM == 4) {
				insert ins = new insert();
				ins.insertDB(conn);
			}else if(NUM == 5) {
				delete del = new delete();
				del.deleteDB(conn);
			}else if(NUM == 6) {
				update up = new update();
				up.updateDB(conn);
			}else if(NUM == 7) {
				drop dr = new drop();
				dr.dropDB(conn);
			}else if(NUM == 8) {
				System.out.println("end the connection");
				conn.close();
			}
		
		} catch (Exception e) {
			System.out.println("connect fail");
			System.out.println("Exception " + e);
		}
	}
}
