package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvcus01Y;
import java.util.List;

public interface Cvcus01YService {
    Cvcus01Y save(Cvcus01Y entity);
    Cvcus01Y findById(Object id);
    List<Cvcus01Y> findAll();
    void deleteById(Object id);
}
