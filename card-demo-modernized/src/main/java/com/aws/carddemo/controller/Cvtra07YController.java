package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra07Y;
import com.aws.carddemo.service.Cvtra07YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra07y")
@RequiredArgsConstructor
public class Cvtra07YController {
    private final Cvtra07YService service;

    @PostMapping
    public ResponseEntity<Cvtra07Y> create(@RequestBody Cvtra07Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra07Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra07Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
