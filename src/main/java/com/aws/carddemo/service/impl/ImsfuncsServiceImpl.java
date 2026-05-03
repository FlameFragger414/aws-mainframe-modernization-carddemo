package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Imsfuncs;
import com.aws.carddemo.repository.ImsfuncsRepository;
import com.aws.carddemo.service.ImsfuncsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImsfuncsServiceImpl implements ImsfuncsService {
    private final ImsfuncsRepository repository;

    @Override
    public Imsfuncs save(Imsfuncs entity) {
        return repository.save(entity);
    }

    @Override
    public Imsfuncs findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Imsfuncs> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
