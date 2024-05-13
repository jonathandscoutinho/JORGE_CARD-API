package com.example.jorgecardproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jorgecardproject.model.User;

public interface IUser extends CrudRepository<User, String>{

}