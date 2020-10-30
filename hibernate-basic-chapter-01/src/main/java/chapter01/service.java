package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class service {

	public static int insertEmployee(Employee employee) {

		Connection conn = null;
		Statement stmt = null;
		int insertionResult = 0;
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost/postgres";
			String user = "postgres";
			String password = "admin123";
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int empId = employee.getEmpId();
			String empName = employee.getEmpName();
			String empAddress = employee.getEmpAddress();
			insertionResult = stmt.executeUpdate("INSERT into employee(empId,empName,empAddress) VALUES(" + empId + ",'"
					+ empName + "','" + empAddress + "')");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException sqle) {
				System.out.println(sqle);
			}

		}
		
		return insertionResult;

	}

}
