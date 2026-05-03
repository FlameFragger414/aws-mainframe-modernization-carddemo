package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Csutldwy;
import com.aws.carddemo.service.CsutldwyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/csutldwy")
@RequiredArgsConstructor
public class CsutldwyController {
    private final CsutldwyService service;

    @PostMapping
    public ResponseEntity<Csutldwy> create(@RequestBody Csutldwy entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Csutldwy>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Csutldwy> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
