package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCDelete {

	public static void main(String[] args) {
		//delete도 update랑 똑같음
		//id를 입력받아서, 아이디에 해당하는 데이터를 delete하는 jdbc코드를 작성

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "HR"; 
		String upw = "HR";

		System.out.println("삭제할 아이디를 입력하세요>");
		Scanner scan = new Scanner(System.in);
		String id = scan.next();
		
		String sql = "DELETE MEMBER WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(url, uid, upw); 
			
			pstmt = conn.prepareStatement(sql); 
		
			pstmt.setString(1, id); //sql = "DELETE MEMBER WHERE ID = ?";
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("삭제 성공");
				
			} else {
				System.out.println("삭제 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				conn.close();
				pstmt.close();
				
			} catch (Exception e2) {
				
			}
		}
		
		
		
	}

}
