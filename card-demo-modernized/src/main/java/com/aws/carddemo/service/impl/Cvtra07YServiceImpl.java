package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvtra07Y;
import com.aws.carddemo.repository.Cvtra07YRepository;
import com.aws.carddemo.service.Cvtra07YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cvtra07YServiceImpl implements Cvtra07YService {
    private final Cvtra07YRepository repository;

    @Override
    public Cvtra07Y save(Cvtra07Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cvtra07Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvtra07Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
