package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csmsg02Y;
import java.util.List;

public interface Csmsg02YService {
    Csmsg02Y save(Csmsg02Y entity);
    Csmsg02Y findById(Object id);
    List<Csmsg02Y> findAll();
    void deleteById(Object id);
}
