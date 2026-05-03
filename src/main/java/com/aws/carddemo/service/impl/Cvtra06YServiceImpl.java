package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra06Y;
import com.aws.carddemo.repository.Cvtra06YRepository;
import com.aws.carddemo.service.Cvtra06YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra06YServiceImpl implements Cvtra06YService {
    private final Cvtra06YRepository repository;

    @Override
    public Cvtra06Y save(Cvtra06Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra06Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra06Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
