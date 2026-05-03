package com.aws.carddemo.service.impl;

import com.aws.carddemo.model.entity.Cvexport;
import com.aws.carddemo.repository.CvexportRepository;
import com.aws.carddemo.service.CvexportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CvexportServiceImpl implements CvexportService {
    private final CvexportRepository repository;

    @Override
    public Cvexport save(Cvexport entity) {
        return repository.save(entity);
    }

    @Override
    public Cvexport findById(Object id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cvexport> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Object id) {
        repository.deleteById(id);
    }
}
