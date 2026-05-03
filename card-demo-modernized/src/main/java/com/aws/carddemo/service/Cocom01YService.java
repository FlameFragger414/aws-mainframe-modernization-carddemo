package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cocom01Y;
import java.util.List;

public interface Cocom01YService {
    Cocom01Y save(Cocom01Y entity);
    Cocom01Y findById(Object id);
    List<Cocom01Y> findAll();
    void deleteById(Object id);
}
