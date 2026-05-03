package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Card;
import java.util.List;

public interface CardService {
    Card save(Card entity);
    Card findById(Object id);
    List<Card> findAll();
    void deleteById(Object id);

    // High-fidelity update method migrated from COCRDUPC.CBL
    Card updateCard(String cardNum, com.aws.carddemo.model.dto.CardUpdateDTO updateDto);
}
