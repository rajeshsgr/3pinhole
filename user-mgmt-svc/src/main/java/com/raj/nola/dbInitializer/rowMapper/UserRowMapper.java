package com.raj.nola.dbInitializer.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.raj.nola.dbInitializer.dto.UserDTO;

public class UserRowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		UserDTO objUser = new UserDTO();
		
		objUser.setUserId(rs.getInt("USER_ID"));
		objUser.setFirstName(rs.getString("FIRST_NAME"));
		objUser.setFirstName(rs.getString("LAST_NAME"));
		objUser.setMemberSince(rs.getDate("MEMBER_SINCE"));
		objUser.setEmail(rs.getString("EMAIL"));
		
		return objUser;
	}

}
