package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csmsg02Y;
import com.aws.carddemo.service.Csmsg02YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csmsg02y")
@RequiredArgsConstructor
public class Csmsg02YController {
    private final Csmsg02YService service;

    @PostMapping
    public ResponseEntity<Csmsg02Y> create(@RequestBody Csmsg02Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csmsg02Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csmsg02Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
