package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cipaudty;
import java.util.List;

public interface CipaudtyService {
    Cipaudty save(Cipaudty entity);
    Cipaudty findById(Object id);
    List<Cipaudty> findAll();
    void deleteById(Object id);
}
