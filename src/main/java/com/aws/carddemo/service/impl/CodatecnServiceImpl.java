package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Codatecn;
import com.aws.carddemo.repository.CodatecnRepository;
import com.aws.carddemo.service.CodatecnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CodatecnServiceImpl implements CodatecnService {
    private final CodatecnRepository repository;

    @Override
    public Codatecn save(Codatecn entity) {
        return repository.save(entity);
    }

    @Override
    public Codatecn findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Codatecn> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
