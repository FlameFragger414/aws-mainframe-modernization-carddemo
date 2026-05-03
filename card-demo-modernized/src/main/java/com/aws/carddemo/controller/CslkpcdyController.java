package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cslkpcdy;
import com.aws.carddemo.service.CslkpcdyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cslkpcdy")
@RequiredArgsConstructor
public class CslkpcdyController {
    private final CslkpcdyService service;

    @PostMapping
    public ResponseEntity<Cslkpcdy> create(@RequestBody Cslkpcdy entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cslkpcdy>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cslkpcdy> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
