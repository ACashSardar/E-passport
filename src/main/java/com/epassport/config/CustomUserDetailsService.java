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
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByLoginId(loginId);
		return user.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user with loginId=" + loginId + " not found."));
	}

}
