package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvcrd01Y;
import java.util.List;

public interface Cvcrd01YService {
    Cvcrd01Y save(Cvcrd01Y entity);
    Cvcrd01Y findById(Object id);
    List<Cvcrd01Y> findAll();
    void deleteById(Object id);
}
