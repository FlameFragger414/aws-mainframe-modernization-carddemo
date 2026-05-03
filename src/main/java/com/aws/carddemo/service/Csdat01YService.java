package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Csdat01Y;
import java.util.List;

public interface Csdat01YService {
    Csdat01Y save(Csdat01Y entity);
    Csdat01Y findById(Object id);
    List<Csdat01Y> findAll();
    void deleteById(Object id);
}
