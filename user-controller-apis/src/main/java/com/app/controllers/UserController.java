package com.app.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.UserDTO;
import com.app.services.UserService;


@RestController
@RequestMapping("/api/tenant")
public class UserController {
	@Autowired
	private UserService userService;

	// POST - Create User
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
		UserDTO createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	// PUT - Update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto, @PathVariable("userId") Integer uid) {
		UserDTO updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	// DELETE - Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
		this.userService.deleteUser(uid);
		//return new ResponseEntity(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true),HttpStatus.OK);
	}
	
	//GET - Get User
	//All users
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//Single User
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserByID(userId));
	}
}
