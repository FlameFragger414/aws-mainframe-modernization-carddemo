package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Coadm02Y;
import java.util.List;

public interface Coadm02YService {
    Coadm02Y save(Coadm02Y entity);
    Coadm02Y findById(Object id);
    List<Coadm02Y> findAll();
    void deleteById(Object id);
}
