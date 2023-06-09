package com.epassport.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.epassport.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmailId(String loginId);
}
