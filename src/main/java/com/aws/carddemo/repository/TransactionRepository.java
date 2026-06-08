package com.aws.carddemo.repository;

import com.aws.carddemo.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Object> {
    java.util.List<Transaction> findByAccount_AcctId(Long acctId);
}
