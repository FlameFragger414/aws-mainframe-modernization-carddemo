package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvact03Y;
import java.util.List;

public interface Cvact03YService {
    Cvact03Y save(Cvact03Y entity);
    Cvact03Y findById(Object id);
    List<Cvact03Y> findAll();
    void deleteById(Object id);
}
