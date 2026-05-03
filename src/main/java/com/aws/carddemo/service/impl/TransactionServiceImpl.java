package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.repository.TransactionRepository;
import com.aws.carddemo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    @Override
    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public Transaction findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
