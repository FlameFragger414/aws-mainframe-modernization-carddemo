package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer save(Customer entity);
    Customer findById(Object id);
    List<Customer> findAll();
    void deleteById(Object id);
}
