package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Account;
import java.util.List;

public interface AccountService {
    Account save(Account entity);
    Account findById(Object id);
    List<Account> findAll();
    void deleteById(Object id);
}
