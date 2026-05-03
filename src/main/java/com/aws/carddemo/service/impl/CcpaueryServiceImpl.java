package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Ccpauery;
import com.aws.carddemo.repository.CcpaueryRepository;
import com.aws.carddemo.service.CcpaueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CcpaueryServiceImpl implements CcpaueryService {
    private final CcpaueryRepository repository;

    @Override
    public Ccpauery save(Ccpauery entity) {
        return repository.save(entity);
    }

    @Override
    public Ccpauery findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ccpauery> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
