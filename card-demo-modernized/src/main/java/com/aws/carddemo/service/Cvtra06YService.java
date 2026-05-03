package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra06Y;
import java.util.List;

public interface Cvtra06YService {
    Cvtra06Y save(Cvtra06Y entity);
    Cvtra06Y findById(Object id);
    List<Cvtra06Y> findAll();
    void deleteById(Object id);
}
