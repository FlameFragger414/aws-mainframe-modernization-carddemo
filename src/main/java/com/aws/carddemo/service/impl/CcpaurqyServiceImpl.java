package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Ccpaurqy;
import com.aws.carddemo.repository.CcpaurqyRepository;
import com.aws.carddemo.service.CcpaurqyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CcpaurqyServiceImpl implements CcpaurqyService {
    private final CcpaurqyRepository repository;

    @Override
    public Ccpaurqy save(Ccpaurqy entity) {
        return repository.save(entity);
    }

    @Override
    public Ccpaurqy findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ccpaurqy> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
