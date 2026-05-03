package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cvtra05Y;
import com.aws.carddemo.service.Cvtra05YService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cvtra05y")
@RequiredArgsConstructor
public class Cvtra05YController {
    private final Cvtra05YService service;

    @PostMapping
    public ResponseEntity<Cvtra05Y> create(@RequestBody Cvtra05Y entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cvtra05Y>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cvtra05Y> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
