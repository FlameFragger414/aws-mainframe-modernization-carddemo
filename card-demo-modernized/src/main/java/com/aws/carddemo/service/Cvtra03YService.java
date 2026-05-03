package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra03Y;
import java.util.List;

public interface Cvtra03YService {
    Cvtra03Y save(Cvtra03Y entity);
    Cvtra03Y findById(Object id);
    List<Cvtra03Y> findAll();
    void deleteById(Object id);
}
