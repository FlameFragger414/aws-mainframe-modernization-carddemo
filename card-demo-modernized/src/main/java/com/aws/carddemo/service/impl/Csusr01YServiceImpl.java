package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.repository.Csusr01YRepository;
import com.aws.carddemo.service.Csusr01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Csusr01YServiceImpl implements Csusr01YService {
    private final Csusr01YRepository repository;

    @Override
    public Csusr01Y save(Csusr01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Csusr01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csusr01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
