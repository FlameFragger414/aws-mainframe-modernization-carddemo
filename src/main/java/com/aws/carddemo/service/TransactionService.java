package com.aws.carddemo.service;

import com.aws.carddemo.model.dto.TransactionDTO;
import com.aws.carddemo.model.entity.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction save(Transaction entity);
    Transaction findById(Object id);
    List<Transaction> findAll();
    void deleteById(Object id);
    Transaction processTransaction(TransactionDTO dto);
    List<Transaction> findByAccountId(Long accountId);
}
