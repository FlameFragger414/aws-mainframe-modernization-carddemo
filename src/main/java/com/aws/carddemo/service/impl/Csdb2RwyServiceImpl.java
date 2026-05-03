package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csdb2Rwy;
import com.aws.carddemo.repository.Csdb2RwyRepository;
import com.aws.carddemo.service.Csdb2RwyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Csdb2RwyServiceImpl implements Csdb2RwyService {
    private final Csdb2RwyRepository repository;

    @Override
    public Csdb2Rwy save(Csdb2Rwy entity) {
        return repository.save(entity);
    }

    @Override
    public Csdb2Rwy findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csdb2Rwy> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
