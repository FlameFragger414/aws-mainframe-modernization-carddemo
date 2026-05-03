package com.aws.carddemo.service.impl;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.exception.ValidationException;
import com.aws.carddemo.model.dto.CardUpdateDTO;
import com.aws.carddemo.model.entity.Card;
import com.aws.carddemo.repository.CardRepository;
import com.aws.carddemo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;

    @Override
    public Card save(Card entity) {
        return repository.save(entity);
    }

    @Override
    public Card findById(Object id) {
        return repository.findById((String)id).orElseThrow(() -> new ResourceNotFoundException("Card not found"));
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById((String)id);
    }

    @Override
    @Transactional
    public Card updateCard(String cardNum, CardUpdateDTO updateDto) {
        Card card = repository.findById(cardNum)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found: " + cardNum));

        validateCardUpdate(updateDto);

        card.setCardEmbossedName(updateDto.getCardEmbossedName());
        card.setCardActiveStatus(updateDto.getCardActiveStatus());
        
        String expiryDate = updateDto.getExpiryYear() + "-" + updateDto.getExpiryMonth() + "-01";
        card.setCardExpirationDate(expiryDate);

        return repository.save(card);
    }

    private void validateCardUpdate(CardUpdateDTO dto) {
        if (!"Y".equalsIgnoreCase(dto.getCardActiveStatus()) && !"N".equalsIgnoreCase(dto.getCardActiveStatus())) {
            throw new ValidationException("Card Active Status must be Y or N");
        }

        try {
            int month = Integer.parseInt(dto.getExpiryMonth());
            if (month < 1 || month > 12) {
                throw new ValidationException("Card expiry month must be between 1 and 12");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid month format");
        }

        try {
            int year = Integer.parseInt(dto.getExpiryYear());
            if (year < 1950 || year > 2099) {
                throw new ValidationException("Invalid card expiry year (1950-2099)");
            }
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid year format");
        }
    }
}
