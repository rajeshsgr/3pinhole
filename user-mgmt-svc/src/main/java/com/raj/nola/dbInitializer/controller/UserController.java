package com.raj.nola.dbInitializer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raj.nola.dbInitializer.dto.UserDTO;
import com.raj.nola.dbInitializer.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAllUsers() {
		return userService.findAllUsers();

	}

	/**
	 * @param userName
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{userName}")
	public List<UserDTO> findUserByName(@PathVariable String userName) {
		
		return userService.findUserByName(userName);

	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public int createUser(@RequestBody UserDTO user) {
		
		return userService.createUser(user);

	}

	/**
	 * @param userID
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{userID}")
	public int deleteUser(@PathVariable int userID) {

		return userService.deleteUser(userID);

	}
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public int updateUser(@RequestBody UserDTO user) {

		return userService.updateUser(user);

	}

}
