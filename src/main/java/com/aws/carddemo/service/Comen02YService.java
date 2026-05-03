package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Comen02Y;
import java.util.List;

public interface Comen02YService {
    Comen02Y save(Comen02Y entity);
    Comen02Y findById(Object id);
    List<Comen02Y> findAll();
    void deleteById(Object id);
}
