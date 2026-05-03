package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Custrec;
import com.aws.carddemo.service.CustrecService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/custrec")
@RequiredArgsConstructor
public class CustrecController {
    private final CustrecService service;

    @PostMapping
    public ResponseEntity<Custrec> create(@RequestBody Custrec entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Custrec>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Custrec> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
