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

import com.example.jorgecardproject.model.Deck;
import com.example.jorgecardproject.service.DeckService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{userId}/deck")
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping
    public ResponseEntity<List<Deck>> listarDecksPorUsuario(@PathVariable Integer userId) throws Exception {
        List<Deck> decks = deckService.listarDecksPorUsuario(userId);
        return ResponseEntity.status(200).body(decks);
    }

    @PostMapping
    public ResponseEntity<Deck> criarDeckParaUsuario(@PathVariable Integer userId, @RequestBody Deck deck) throws Exception {
        Deck novoDeck = deckService.criarDeckParaUsuario(userId, deck);
        return ResponseEntity.status(201).body(novoDeck);
    }

    @PutMapping("/{deckId}")
    public ResponseEntity<Deck> editarDeck(@PathVariable Integer userId, @PathVariable Integer deckId, @RequestBody Deck deck) throws Exception {
        Deck deckEditado = deckService.editarDeck(deckId, deck);
        return ResponseEntity.status(200).body(deckEditado);
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<?> excluirDeck(@PathVariable Integer userId, @PathVariable Integer deckId) {
        deckService.excluirDeck(deckId);
        return ResponseEntity.status(204).build();
    }
}
