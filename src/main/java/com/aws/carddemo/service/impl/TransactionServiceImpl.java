package com.aws.carddemo.service.impl;

import com.aws.carddemo.exception.ResourceNotFoundException;
import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Transaction;
import com.aws.carddemo.repository.TransactionRepository;
import com.aws.carddemo.service.TransactionService;
import com.aws.carddemo.service.business.TransactionProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;
    private final TransactionProcessingService transactionProcessingService;

    @Override
    public Transaction save(Transaction entity) {
        return repository.save(entity);
    }

    @Override
    public Transaction findById(Object id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found: " + id));
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }

    @Override
    public Transaction processTransaction(TransactionDTO dto) {
        return transactionProcessingService.addTransaction(dto);
    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return transactionProcessingService.listTransactionsByAccount(accountId);
    }
}
