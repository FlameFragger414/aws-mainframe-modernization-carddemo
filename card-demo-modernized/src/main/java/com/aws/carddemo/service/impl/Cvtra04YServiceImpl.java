package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra04Y;
import com.aws.carddemo.repository.Cvtra04YRepository;
import com.aws.carddemo.service.Cvtra04YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra04YServiceImpl implements Cvtra04YService {
    private final Cvtra04YRepository repository;

    @Override
    public Cvtra04Y save(Cvtra04Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra04Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra04Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
