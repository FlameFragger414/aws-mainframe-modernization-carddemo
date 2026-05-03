package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvact01Y;
import java.util.List;

public interface Cvact01YService {
    Cvact01Y save(Cvact01Y entity);
    Cvact01Y findById(Object id);
    List<Cvact01Y> findAll();
    void deleteById(Object id);
}
