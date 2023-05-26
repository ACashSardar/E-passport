package com.epassport.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epassport.entities.User;
import com.epassport.repositories.UserRepository;
import com.epassport.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Integer userId, User user) {
		User user2=userRepository.findById(userId).get();
		if(user.getFirstName()!=null) user2.setFirstName(user.getFirstName());
		if(user.getLastName()!=null) user2.setLastName(user.getLastName());
		if(user.getDob()!=null) user2.setDob(user.getDob());
		if(user.getGender()!=null) user2.setGender(user.getGender());
		if(user.getEmailId()!=null) user2.setEmailId(user.getEmailId());
		if(user.getPhoneNo()!=null) user2.setPhoneNo(user.getPhoneNo());
		if(user.getUserType()!=null) user2.setUserType(user.getUserType());
		return userRepository.save(user2);
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User getUserByEmailId(String emailId) {
		return userRepository.getUserByEmailId(emailId);
	}

	@Override
	public User getUserByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId).get();
	}

}
