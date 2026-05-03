package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csmsg01Y;
import com.aws.carddemo.service.Csmsg01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csmsg01y")
@RequiredArgsConstructor
public class Csmsg01YController {
    private final Csmsg01YService service;

    @PostMapping
    public ResponseEntity<Csmsg01Y> create(@RequestBody Csmsg01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csmsg01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csmsg01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
