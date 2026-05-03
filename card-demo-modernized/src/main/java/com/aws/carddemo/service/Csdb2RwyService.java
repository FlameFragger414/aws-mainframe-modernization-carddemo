package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csdb2Rwy;
import java.util.List;

public interface Csdb2RwyService {
    Csdb2Rwy save(Csdb2Rwy entity);
    Csdb2Rwy findById(Object id);
    List<Csdb2Rwy> findAll();
    void deleteById(Object id);
}
