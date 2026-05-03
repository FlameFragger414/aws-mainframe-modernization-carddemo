package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Coadm02Y;
import com.aws.carddemo.repository.Coadm02YRepository;
import com.aws.carddemo.service.Coadm02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Coadm02YServiceImpl implements Coadm02YService {
    private final Coadm02YRepository repository;

    @Override
    public Coadm02Y save(Coadm02Y entity) {
        return repository.save(entity);
    }

    @Override
    public Coadm02Y findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Coadm02Y> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
