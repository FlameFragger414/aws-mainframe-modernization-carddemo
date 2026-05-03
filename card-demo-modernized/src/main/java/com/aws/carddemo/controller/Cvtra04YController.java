package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra04Y;
import com.aws.carddemo.service.Cvtra04YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra04y")
@RequiredArgsConstructor
public class Cvtra04YController {
    private final Cvtra04YService service;

    @PostMapping
    public ResponseEntity<Cvtra04Y> create(@RequestBody Cvtra04Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra04Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra04Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
