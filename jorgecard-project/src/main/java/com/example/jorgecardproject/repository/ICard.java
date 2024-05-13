package com.example.jorgecardproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.jorgecardproject.model.Card;
import com.example.jorgecardproject.model.Deck;

public interface ICard extends CrudRepository<Card, Integer>{

	List<Card> findByDeck(Deck deck);

}
