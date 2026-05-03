package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra06Y;
import com.aws.carddemo.service.Cvtra06YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra06y")
@RequiredArgsConstructor
public class Cvtra06YController {
    private final Cvtra06YService service;

    @PostMapping
    public ResponseEntity<Cvtra06Y> create(@RequestBody Cvtra06Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra06Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra06Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
