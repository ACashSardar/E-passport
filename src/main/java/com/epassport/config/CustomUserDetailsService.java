package com.epassport.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.epassport.entities.User;
import com.epassport.repositories.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmailId(emailId);
		return user.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user with emailId=" + emailId + " not found."));
	}
}
