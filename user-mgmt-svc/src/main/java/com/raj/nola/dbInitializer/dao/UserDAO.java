/**
 * 
 */
package com.raj.nola.dbInitializer.dao;

import java.util.List;

import com.raj.nola.dbInitializer.dto.UserDTO;


/**
 * @author 703002099
 *
 */
public interface UserDAO {
	
	/**
	 * @param user
	 * @return
	 */
	int createUser(UserDTO user);

	/**
	 * @param user
	 * @return
	 */
	int updateUser(UserDTO user);
	
	/**
	 * @param firstName
	 * @return
	 */
	List<UserDTO> findUserByName(String firstName);

	/**
	 * @param userID
	 * @return
	 */
	int deleteUser(int userID);
	
	/**
	 * @return
	 */
	List<UserDTO> findAllUsers();
	
	

}
