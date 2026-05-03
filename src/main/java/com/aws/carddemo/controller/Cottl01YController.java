package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cottl01Y;
import com.aws.carddemo.service.Cottl01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cottl01y")
@RequiredArgsConstructor
public class Cottl01YController {
    private final Cottl01YService service;

    @PostMapping
    public ResponseEntity<Cottl01Y> create(@RequestBody Cottl01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cottl01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cottl01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
