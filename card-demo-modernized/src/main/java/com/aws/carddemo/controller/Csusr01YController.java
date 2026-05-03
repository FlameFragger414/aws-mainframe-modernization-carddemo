package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csusr01Y;
import com.aws.carddemo.service.Csusr01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csusr01y")
@RequiredArgsConstructor
public class Csusr01YController {
    private final Csusr01YService service;

    @PostMapping
    public ResponseEntity<Csusr01Y> create(@RequestBody Csusr01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csusr01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csusr01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
