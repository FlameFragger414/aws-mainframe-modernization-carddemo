package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra01Y;
import java.util.List;

public interface Cvtra01YService {
    Cvtra01Y save(Cvtra01Y entity);
    Cvtra01Y findById(Object id);
    List<Cvtra01Y> findAll();
    void deleteById(Object id);
}
