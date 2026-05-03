package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra04Y;
import java.util.List;

public interface Cvtra04YService {
    Cvtra04Y save(Cvtra04Y entity);
    Cvtra04Y findById(Object id);
    List<Cvtra04Y> findAll();
    void deleteById(Object id);
}
