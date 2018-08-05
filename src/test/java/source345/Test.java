package source345;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.9.9:3306/mybatis?useSSL=FALSE","root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from sys_user");
			while (rs.next()) {
				for (int i = 1; i <= 2; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
