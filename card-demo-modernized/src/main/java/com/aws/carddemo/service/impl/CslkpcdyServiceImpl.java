package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cslkpcdy;
import com.aws.carddemo.repository.CslkpcdyRepository;
import com.aws.carddemo.service.CslkpcdyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CslkpcdyServiceImpl implements CslkpcdyService {
    private final CslkpcdyRepository repository;

    @Override
    public Cslkpcdy save(Cslkpcdy entity) {
        return repository.save(entity);
    }

    @Override
    public Cslkpcdy findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cslkpcdy> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
