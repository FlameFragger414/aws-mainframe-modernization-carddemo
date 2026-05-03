package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Csdat01Y;
import com.aws.carddemo.repository.Csdat01YRepository;
import com.aws.carddemo.service.Csdat01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Csdat01YServiceImpl implements Csdat01YService {
    private final Csdat01YRepository repository;

    @Override
    public Csdat01Y save(Csdat01Y entity) {
        return repository.save(entity);
    }

    @Override
    public Csdat01Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Csdat01Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
