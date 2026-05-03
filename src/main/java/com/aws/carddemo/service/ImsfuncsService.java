package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Imsfuncs;
import java.util.List;

public interface ImsfuncsService {
    Imsfuncs save(Imsfuncs entity);
    Imsfuncs findById(Object id);
    List<Imsfuncs> findAll();
    void deleteById(Object id);
}
