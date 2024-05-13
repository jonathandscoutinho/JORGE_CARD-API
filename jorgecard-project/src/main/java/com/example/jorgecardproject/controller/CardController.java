package com.example.jorgecardproject.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jorgecardproject.model.Card;
import com.example.jorgecardproject.service.CardService;

@RestController
@CrossOrigin("*")
@RequestMapping("/deck/{deckId}/card")
public class CardController {

	 private final CardService cardService;

	    public CardController(CardService cardService) {
	        this.cardService = cardService;
	    }

	    @GetMapping
	    public ResponseEntity<List<Card>> listarCardsPorDeck(@PathVariable Integer deckId) throws Exception {
	        List<Card> cards = cardService.listarCardsPorDeck(deckId);
	        return ResponseEntity.status(200).body(cards);
	    }

	    @PostMapping
	    public ResponseEntity<Card> criarCardParaDeck(@PathVariable Integer deckId, @RequestBody Card card) throws Exception {
	        Card novoCard = cardService.criarCardParaDeck(deckId, card);
	        return ResponseEntity.status(201).body(novoCard);
	    }

	    @PutMapping("/{cardId}")
	    public ResponseEntity<Card> editarCard(@PathVariable Integer deckId, @PathVariable Integer cardId, @RequestBody Card card) throws Exception {
	        Card cardEditado = cardService.editarCard(cardId, card);
	        return ResponseEntity.status(200).body(cardEditado);
	    }

	    @DeleteMapping("/{cardId}")
	    public ResponseEntity<?> excluirCard(@PathVariable Integer deckId, @PathVariable Integer cardId) {
	        cardService.excluirCard(cardId);
	        return ResponseEntity.status(204).build();
	    }
	    
}
