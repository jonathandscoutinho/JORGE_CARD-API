package com.example.jorgecardproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jorgecardproject.model.Card;
import com.example.jorgecardproject.model.Deck;
import com.example.jorgecardproject.repository.ICard;
import com.example.jorgecardproject.repository.IDeck;

@Service
public class CardService {

    private final ICard cardRepository;
    private final IDeck deckRepository;

    public CardService(ICard cardRepository, IDeck deckRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
    }

    public List<Card> listarCardsPorDeck(Integer deckId) throws Exception {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            return cardRepository.findByDeck(deck);
        } else {
            throw new Exception("Deck com ID " + deckId + " não encontrado.");
        }
    }

    public Card criarCardParaDeck(Integer deckId, Card card) throws Exception {
        Optional<Deck> deckOptional = deckRepository.findById(deckId);
        if (deckOptional.isPresent()) {
            Deck deck = deckOptional.get();
            card.setDeck(deck);
            return cardRepository.save(card);
        } else {
            throw new Exception("Deck com ID " + deckId + " não encontrado.");
        }
    }

    public Card editarCard(Integer cardId, Card card) throws Exception {
        Optional<Card> existingCardOptional = cardRepository.findById(cardId);
        if (existingCardOptional.isPresent()) {
            Card existingCard = existingCardOptional.get();
            existingCard.setQuestion(card.getQuestion());
            existingCard.setAnswer(card.getAnswer());
            return cardRepository.save(existingCard);
        } else {
            throw new Exception("Card com ID " + cardId + " não encontrado.");
        }
    }

    public void excluirCard(Integer cardId) {
        cardRepository.deleteById(cardId);
    }
}
