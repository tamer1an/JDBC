package org.tamer1an.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tamer1an.model.Circle;
import org.springframework.jdbc.core.JdbcTemplate;
@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	public Circle getCircle(int circleId){		
		Connection conn = null;	
		
		try {
			//Class.forName(driver).newInstance();
			
			conn = dataSource.getConnection();
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
	
	public int getCircleCount(){
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.queryForInt(sql);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
