package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cottl01Y;
import java.util.List;

public interface Cottl01YService {
    Cottl01Y save(Cottl01Y entity);
    Cottl01Y findById(Object id);
    List<Cottl01Y> findAll();
    void deleteById(Object id);
}
