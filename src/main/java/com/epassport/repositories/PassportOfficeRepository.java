package com.epassport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epassport.entities.PassportOffice;

public interface PassportOfficeRepository extends JpaRepository<PassportOffice, Integer> {

}
