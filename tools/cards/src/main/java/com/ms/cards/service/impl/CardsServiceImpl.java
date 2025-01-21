package com.ms.cards.service.impl;

import com.ms.cards.constants.CardConstants;
import com.ms.cards.dto.CardsDto;
import com.ms.cards.entity.Card;
import com.ms.cards.exception.CardAlreadyExistsException;
import com.ms.cards.exception.ResourceNotFoundException;
import com.ms.cards.mapper.CardsMapper;
import com.ms.cards.repository.CardRepository;
import com.ms.cards.service.ICardsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardsServiceImpl implements ICardsService {

    private CardRepository cardRepository;

    public CardsServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> optionalCards= cardRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    /**
     * @param mobileNumber - Input mobile Number
     * @return
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber));

        return CardsMapper.mapToCardsDto(card, new CardsDto());
    }

    /**
     * @param cardsDto - CardsDto Object
     * @return
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Card cards = cardRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardRepository.save(cards);
        return  true;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        Card cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(cards.getCardId());
        return true;
    }

    private Card createNewCard(String mobileNumber) {
        Card newCard = new Card();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return newCard;
    }
}
