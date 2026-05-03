package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Codatecn;
import java.util.List;

public interface CodatecnService {
    Codatecn save(Codatecn entity);
    Codatecn findById(Object id);
    List<Codatecn> findAll();
    void deleteById(Object id);
}
