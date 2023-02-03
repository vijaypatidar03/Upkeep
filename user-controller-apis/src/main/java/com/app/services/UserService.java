package com.app.services;

import java.util.List;

import com.app.payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDto);

	UserDTO updateUser(UserDTO user, Integer userId);

	UserDTO getUserByID(Integer usedId);

	List<UserDTO> getAllUsers();

	void deleteUser(Integer userId);

}
