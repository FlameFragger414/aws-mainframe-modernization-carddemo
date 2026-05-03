package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Card;
import com.aws.carddemo.repository.CardRepository;
import com.aws.carddemo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Card> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
