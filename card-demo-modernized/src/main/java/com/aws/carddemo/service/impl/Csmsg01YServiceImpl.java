package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csmsg01Y;
import com.aws.carddemo.repository.Csmsg01YRepository;
import com.aws.carddemo.service.Csmsg01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Csmsg01YServiceImpl implements Csmsg01YService {
    private final Csmsg01YRepository repository;

    @Override
    public Csmsg01Y save(Csmsg01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Csmsg01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csmsg01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
