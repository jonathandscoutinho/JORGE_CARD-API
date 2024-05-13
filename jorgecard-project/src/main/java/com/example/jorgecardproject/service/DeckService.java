package com.example.jorgecardproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jorgecardproject.model.Deck;
import com.example.jorgecardproject.model.User;
import com.example.jorgecardproject.repository.IDeck;
import com.example.jorgecardproject.repository.IUser;

@Service
public class DeckService {

    private final IDeck deckRepository;
    private final IUser userRepository;

    public DeckService(IDeck deckRepository, IUser userRepository) {
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
    }

    public List<Deck> listarDecksPorUsuario(Integer userId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return deckRepository.findByUser(user);
        } else {
            throw new Exception("Usuário com ID " + userId + " não encontrado.");
        }
    }

    public Deck criarDeckParaUsuario(Integer userId, Deck deck) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            deck.setUser(user);
            return deckRepository.save(deck);
        } else {
            throw new Exception("Usuário com ID " + userId + " não encontrado.");
        }
    }

    public Deck editarDeck(Integer deckId, Deck deck) throws Exception {
        Optional<Deck> existingDeckOptional = deckRepository.findById(deckId);
        if (existingDeckOptional.isPresent()) {
            Deck existingDeck = existingDeckOptional.get();
            existingDeck.setName(deck.getName());
            // Outros campos para edição, se necessário
            return deckRepository.save(existingDeck);
        } else {
            throw new Exception("Deck com ID " + deckId + " não encontrado.");
        }
    }

    public void excluirDeck(Integer deckId) {
        deckRepository.deleteById(deckId);
    }
}
