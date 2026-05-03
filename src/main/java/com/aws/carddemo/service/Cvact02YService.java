package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvact02Y;
import java.util.List;

public interface Cvact02YService {
    Cvact02Y save(Cvact02Y entity);
    Cvact02Y findById(Object id);
    List<Cvact02Y> findAll();
    void deleteById(Object id);
}
