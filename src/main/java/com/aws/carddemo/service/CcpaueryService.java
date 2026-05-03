package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Ccpauery;
import java.util.List;

public interface CcpaueryService {
    Ccpauery save(Ccpauery entity);
    Ccpauery findById(Object id);
    List<Ccpauery> findAll();
    void deleteById(Object id);
}
