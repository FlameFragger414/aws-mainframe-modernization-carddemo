package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cipaudty;
import com.aws.carddemo.service.CipaudtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cipaudty")
@RequiredArgsConstructor
public class CipaudtyController {
    private final CipaudtyService service;

    @PostMapping
    public ResponseEntity<Cipaudty> create(@RequestBody Cipaudty entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cipaudty>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cipaudty> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
