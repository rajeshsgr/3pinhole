package com.raj.nola.dbInitializer.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author 703002099
 *
 */
public class UserDTO {
	
	private int userId;
	private String firstName;
	private String lastName;
	
	// Formats output date when this DTO is passed through JSON
	@JsonFormat(pattern = "yyyy-mm-dd")
	
	// Allows dd/MM/yyyy date to be passed into GET request in JSON
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date memberSince;
	
	private String email;
	
	
	
	
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the memberSince
	 */
	public Date getMemberSince() {
		return memberSince;
	}
	/**
	 * @param memberSince the memberSince to set
	 */
	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
