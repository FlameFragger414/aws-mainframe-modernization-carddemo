package com.aws.carddemo.service;

import com.aws.carddemo.model.entity.Unused1Y;
import java.util.List;

public interface Unused1YService {
    Unused1Y save(Unused1Y entity);
    Unused1Y findById(Object id);
    List<Unused1Y> findAll();
    void deleteById(Object id);
}
