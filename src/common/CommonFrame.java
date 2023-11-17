package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 프레임이 공통으로 가지고 있어야 하는 것을 정의한 클래스
 */

public class CommonFrame {
	static Connection con;
	static Statement stmt;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/miriead?serverTimezone=UTC", "root", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// R
	public static ResultSet getResult(String sql, Object... p) {
		try {
			var pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < p.length; i++) {
				pstmt.setObject(i + 1, p[i]);
			}
			
			return pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// C, U, D
	public static ResultSet updateSQL(String sql, Object... p) { // void형으로 바꾸고 return 없애도 가능
		try {
			var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			for(int i = 0; i < p.length; i++) {
				pstmt.setObject(i + 1, p[i]);
			}
			
			pstmt.executeUpdate();
			
			return pstmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static List<String> getColumnDataFromTable(String tableName, String... columnNames) {
	    List<String> data = new ArrayList<>();
	    try {
	        String columns = String.join(", ", columnNames); // 열 이름을 쉼표로 구분하여 문자열로 조합
	        String query = "SELECT " + columns + " FROM " + tableName;
	        ResultSet resultSet = stmt.executeQuery(query);

	        while (resultSet.next()) {
	            for (String columnName : columnNames) {
	                data.add(resultSet.getString(columnName));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return data;
	}

}