package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Account;
import com.aws.carddemo.repository.AccountRepository;
import com.aws.carddemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Override
    public Account save(Account entity) {
        return repository.save(entity);
    }

    @Override
    public Account findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
