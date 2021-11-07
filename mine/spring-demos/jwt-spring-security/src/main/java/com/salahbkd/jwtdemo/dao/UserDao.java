package com.salahbkd.jwtdemo.dao;

import com.salahbkd.jwtdemo.entity.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
	
}