package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cvtra05Y;
import java.util.List;

public interface Cvtra05YService {
    Cvtra05Y save(Cvtra05Y entity);
    Cvtra05Y findById(Object id);
    List<Cvtra05Y> findAll();
    void deleteById(Object id);
}
