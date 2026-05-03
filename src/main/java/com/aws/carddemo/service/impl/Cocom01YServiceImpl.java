package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cocom01Y;
import com.aws.carddemo.repository.Cocom01YRepository;
import com.aws.carddemo.service.Cocom01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Cocom01YServiceImpl implements Cocom01YService {
    private final Cocom01YRepository repository;

    @Override
    public Cocom01Y save(Cocom01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Cocom01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cocom01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
