package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Codatecn;
import com.aws.carddemo.service.CodatecnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/codatecn")
@RequiredArgsConstructor
public class CodatecnController {
    private final CodatecnService service;

    @PostMapping
    public ResponseEntity<Codatecn> create(@RequestBody Codatecn entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Codatecn>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Codatecn> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
