package com.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.User;
import com.app.exceptions.ResourceNotFoundException;
import com.app.payloads.UserDTO;
import com.app.repos.UserRepo;
import com.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setCustomerId(userDto.getCustomerId());
		user.setCustomerName(userDto.getCustomerName());
		user.setCustomerEmail(userDto.getCustomerEmail());
		user.setCustomerImage(userDto.getCustomerImage());
		user.setProjectName(userDto.getProjectName());
		user.setStatus(userDto.getStatus());
		user.setStatusBg(userDto.getStatusBg());
		user.setWeeks(userDto.getWeeks());
		user.setBudget(userDto.getBudget());
		user.setBudget(userDto.getBudget());
		user.setLocation(userDto.getLocation());
		User updatedUser = this.userRepo.save(user);
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDTO getUserByID(Integer usedId) {
		User user = this.userRepo.findById(usedId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", usedId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDTO dto) {
		User user = this.modelMapper.map(dto, User.class);
//		Removing manual conversion and using ModelMapper;
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setEmail(dto.getEmail());
//		user.setPassword(dto.getPassword());
//		user.setAbout(dto.getAbout());
		return user;
	}

	public UserDTO userToDto(User user) {
		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
