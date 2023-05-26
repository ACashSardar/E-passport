package com.epassport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epassport.entities.ApplicationForm;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Integer> {

}
