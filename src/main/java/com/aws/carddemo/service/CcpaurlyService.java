package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Ccpaurly;
import java.util.List;

public interface CcpaurlyService {
    Ccpaurly save(Ccpaurly entity);
    Ccpaurly findById(Object id);
    List<Ccpaurly> findAll();
    void deleteById(Object id);
}
