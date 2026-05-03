package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra03Y;
import com.aws.carddemo.repository.Cvtra03YRepository;
import com.aws.carddemo.service.Cvtra03YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra03YServiceImpl implements Cvtra03YService {
    private final Cvtra03YRepository repository;

    @Override
    public Cvtra03Y save(Cvtra03Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra03Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra03Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
