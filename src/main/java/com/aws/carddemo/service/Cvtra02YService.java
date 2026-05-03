package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra02Y;
import java.util.List;

public interface Cvtra02YService {
    Cvtra02Y save(Cvtra02Y entity);
    Cvtra02Y findById(Object id);
    List<Cvtra02Y> findAll();
    void deleteById(Object id);
}
