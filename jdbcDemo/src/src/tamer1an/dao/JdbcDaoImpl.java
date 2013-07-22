package src.tamer1an.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.tamer1an.model.Circle;

public class JdbcDaoImpl {
	
	public Circle getCircle(int circleId){
		
		Connection conn = null;	
		String driver = "org.apache.derby.jdbc.ClientDriver";
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
			ps.setInt(1, circleId);
			
			Circle circle = null;
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				circle = new Circle(circleId, rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			
			return circle;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		
		return null;		
	}
}
