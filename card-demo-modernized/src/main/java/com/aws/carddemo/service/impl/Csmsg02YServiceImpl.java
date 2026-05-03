package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csmsg02Y;
import com.aws.carddemo.repository.Csmsg02YRepository;
import com.aws.carddemo.service.Csmsg02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Csmsg02YServiceImpl implements Csmsg02YService {
    private final Csmsg02YRepository repository;

    @Override
    public Csmsg02Y save(Csmsg02Y entity) {
        return repository.save(entity);
    }

    @Override
    public Csmsg02Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csmsg02Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
