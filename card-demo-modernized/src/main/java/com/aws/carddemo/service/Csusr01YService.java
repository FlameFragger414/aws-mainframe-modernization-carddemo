package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csusr01Y;
import java.util.List;

public interface Csusr01YService {
    Csusr01Y save(Csusr01Y entity);
    Csusr01Y findById(Object id);
    List<Csusr01Y> findAll();
    void deleteById(Object id);
}
