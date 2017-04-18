/**
 * 
 */
package com.raj.nola.dbInitializer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raj.nola.dbInitializer.dao.UserDAO;
import com.raj.nola.dbInitializer.dto.UserDTO;

/**
 * @author 703002099
 *
 */
@Component
public class UserService {

	@Autowired
	UserDAO userDAO;

	/**
	 * @param userName
	 * @return
	 */
	public List<UserDTO> findUserByName(String userName) {

		List<UserDTO> userList = userDAO.findUserByName(userName);

		return userList;

	}
	
	/**
	 * @param userName
	 * @return
	 */
	public List<UserDTO> findAllUsers() {

		List<UserDTO> userList = userDAO.findAllUsers();

		return userList;

	}

	/**
	 * @param user
	 * @return
	 */
	public int createUser(UserDTO user) {

		int status = userDAO.createUser(user);

		return status;

	}

	/**
	 * @param userID
	 * @return
	 */
	public int deleteUser(int userID) {

		int status = userDAO.deleteUser(userID);

		return status;

	}
	
	/**
	 * @param user
	 * @return
	 */
	public int updateUser(UserDTO user) {

		int status = userDAO.updateUser(user);

		return status;

	}
	
	
	
}
