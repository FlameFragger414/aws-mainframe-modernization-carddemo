package com.aws.carddemo.service;

import com.aws.carddemo.model.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {
    TransactionDTO processTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransactionById(String id);
    List<TransactionDTO> getTransactionsByAccountId(Long accountId);
}
