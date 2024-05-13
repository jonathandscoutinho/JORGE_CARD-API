package com.example.jorgecardproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.jorgecardproject.model.Deck;
import com.example.jorgecardproject.model.User;

public interface IDeck extends CrudRepository<Deck, Integer>{

	List<Deck> findByUser(User user);

}