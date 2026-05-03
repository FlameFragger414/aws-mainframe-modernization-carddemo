package com.aws.carddemo.controller;

import com.aws.carddemo.model.entity.Cipausmy;
import com.aws.carddemo.service.CipausmyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cipausmy")
@RequiredArgsConstructor
public class CipausmyController {
    private final CipausmyService service;

    @PostMapping
    public ResponseEntity<Cipausmy> create(@RequestBody Cipausmy entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cipausmy>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cipausmy> getById(@PathVariable Object id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Object id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
