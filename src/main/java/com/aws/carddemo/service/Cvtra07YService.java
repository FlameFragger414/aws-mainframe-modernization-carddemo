package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra07Y;
import java.util.List;

public interface Cvtra07YService {
    Cvtra07Y save(Cvtra07Y entity);
    Cvtra07Y findById(Object id);
    List<Cvtra07Y> findAll();
    void deleteById(Object id);
}
