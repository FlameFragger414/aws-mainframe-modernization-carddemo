package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Custrec;
import java.util.List;

public interface CustrecService {
    Custrec save(Custrec entity);
    Custrec findById(Object id);
    List<Custrec> findAll();
    void deleteById(Object id);
}
