package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cipausmy;
import java.util.List;

public interface CipausmyService {
    Cipausmy save(Cipausmy entity);
    Cipausmy findById(Object id);
    List<Cipausmy> findAll();
    void deleteById(Object id);
}
