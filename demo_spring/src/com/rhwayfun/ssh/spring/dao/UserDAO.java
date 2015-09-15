package com.rhwayfun.ssh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rhwayfun.ssh.spring.pojo.User;

public class UserDAO {

	private DataSource dataSource;

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isValid(String username,String password){
		List<User> userList = new ArrayList<User>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from user where name='" + username + "' and password='" + password + "'";
		userList = jdbcTemplate.query(sql, 
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setEmail(rs.getString("email"));
						return user;
					}
				});
		if(userList.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isExist(String username){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForInt("select count(*) from user where name='" + username + "'");
		if(count > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void insert(String username,String password,String email){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into user(name,password,email) values('" + username + "','" 
						+ password + "','" + email + "');";
		jdbcTemplate.update(sql);
	}
}
