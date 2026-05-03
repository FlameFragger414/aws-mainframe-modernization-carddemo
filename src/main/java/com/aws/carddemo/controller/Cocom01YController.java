package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cocom01Y;
import com.aws.carddemo.service.Cocom01YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cocom01y")
@RequiredArgsConstructor
public class Cocom01YController {
    private final Cocom01YService service;

    @PostMapping
    public ResponseEntity<Cocom01Y> create(@RequestBody Cocom01Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cocom01Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cocom01Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
