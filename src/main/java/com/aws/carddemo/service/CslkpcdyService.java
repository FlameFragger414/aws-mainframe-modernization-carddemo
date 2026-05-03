package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Cslkpcdy;
import java.util.List;

public interface CslkpcdyService {
    Cslkpcdy save(Cslkpcdy entity);
    Cslkpcdy findById(Object id);
    List<Cslkpcdy> findAll();
    void deleteById(Object id);
}
