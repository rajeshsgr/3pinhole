/**
 * 
 */
package com.raj.nola.dbInitializer.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.raj.nola.dbInitializer.dao.UserDAO;
import com.raj.nola.dbInitializer.dto.UserDTO;
import com.raj.nola.dbInitializer.rowMapper.UserRowMapper;

/**
 * @author 703002099
 *
 */
@Component
public class UserDAOImpl implements UserDAO {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/* (non-Javadoc)
	 * @see com.genpact.commonsvs.dbInitializer.UserDAO#createUser(com.genpact.commonsvs.dbInitializer.dto.UserDTO)
	 */
	@Override
	public int createUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		String userCreateSQL ="INSERT INTO USERS(FIRST_NAME,LAST_NAME,MEMBER_SINCE,EMAIL) VALUES (:FIRSTNAME,:LASTNAME,:MEMBERSINCE,:EMAIL)";
		
		Map<String, Object> inputMap = new HashMap<String, Object>();
		
		inputMap.put("FIRSTNAME", user.getFirstName());
		inputMap.put("LASTNAME", user.getLastName());
		inputMap.put("MEMBERSINCE", user.getMemberSince());
		inputMap.put("EMAIL", user.getEmail());

		
		int status=namedParameterJdbcTemplate.update(userCreateSQL, inputMap);
		
		return status;
	}

	/* (non-Javadoc)
	 * @see com.genpact.commonsvs.dbInitializer.UserDAO#deleteUser(com.genpact.commonsvs.dbInitializer.dto.UserDTO)
	 */
	@Override
	public int deleteUser(int userID) {
		// TODO Auto-generated method stub
		
		String deleteUserSQL="DELETE FROM USERS WHERE USER_ID=:USERID";
		
		  SqlParameterSource paramSource = new MapSqlParameterSource("USERID", userID);

		  int status=namedParameterJdbcTemplate.update(deleteUserSQL,paramSource);

				
		return status;
	}

	/* (non-Javadoc)
	 * @see com.genpact.commonsvs.dbInitializer.UserDAO#updateUser(com.genpact.commonsvs.dbInitializer.dto.UserDTO)
	 */
	@Override
	public int updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		String updateSQL ="UPDATE USERS SET FIRST_NAME=:FIRSTNAME,LAST_NAME=:LASTNAME,MEMBER_SINCE=:MEMBERSINCE,EMAIL=:EMAIL WHERE USER_ID=:ID";
		
		Map<String, Object> inputMap = new HashMap<String, Object>();
		
		inputMap.put("ID", user.getUserId());
		inputMap.put("FIRSTNAME", user.getFirstName());
		inputMap.put("LASTNAME", user.getLastName());
		inputMap.put("MEMBERSINCE", user.getMemberSince());
		inputMap.put("EMAIL", user.getEmail());
		
		int status=namedParameterJdbcTemplate.update(updateSQL, inputMap);

		
		return status;
	}

	/* (non-Javadoc)
	 * @see com.genpact.commonsvs.dbInitializer.UserDAO#findUserByName(java.lang.String)
	 */
	@Override
	public List<UserDTO> findUserByName(String firstName) {
		// TODO Auto-generated method stub
		
		String findByIDSQL ="SELECT USER_ID,FIRST_NAME,LAST_NAME,MEMBER_SINCE,EMAIL from USERS WHERE FIRST_NAME LIKE '%'||:FIRSTNAME||'%'";
		
		Map<String, Object> inputMap = new HashMap<String, Object>();
		
		inputMap.put("FIRSTNAME", firstName);
		
		List<UserDTO> user=namedParameterJdbcTemplate.query(findByIDSQL, inputMap, new UserRowMapper());

		return user;
	}

	/* (non-Javadoc)
	 * @see com.genpact.commonsvs.dbInitializer.UserDAO#findAllUsers()
	 */
	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		
		String findAllUsersSQL ="SELECT USER_ID,FIRST_NAME,LAST_NAME,MEMBER_SINCE,EMAIL from USERS";
		
		List<UserDTO> users=namedParameterJdbcTemplate.query(findAllUsersSQL, new UserRowMapper());
		
		return users;
	}

}
