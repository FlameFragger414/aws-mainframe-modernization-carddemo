package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csmsg01Y;
import java.util.List;

public interface Csmsg01YService {
    Csmsg01Y save(Csmsg01Y entity);
    Csmsg01Y findById(Object id);
    List<Csmsg01Y> findAll();
    void deleteById(Object id);
}
