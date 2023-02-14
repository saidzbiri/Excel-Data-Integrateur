package com.excel.data.integrateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.data.integrateur.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
