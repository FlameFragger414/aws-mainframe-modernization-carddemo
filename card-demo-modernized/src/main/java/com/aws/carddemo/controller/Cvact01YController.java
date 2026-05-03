package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvact01Y;
import com.aws.carddemo.service.Cvact01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvact01y")
@RequiredArgsConstructor
public class Cvact01YController {
    private final Cvact01YService service;

    @PostMapping
    public ResponseEntity<Cvact01Y> create(@RequestBody Cvact01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvact01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvact01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
