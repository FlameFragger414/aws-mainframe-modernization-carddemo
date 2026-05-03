package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Customer;
import com.aws.carddemo.repository.CustomerRepository;
import com.aws.carddemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
