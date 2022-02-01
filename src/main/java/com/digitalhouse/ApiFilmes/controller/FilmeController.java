package com.digitalhouse.ApiFilmes.controller;

import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*", exposedHeaders = "")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping
    public ResponseEntity<List<Filme>> getAll(){
        return ResponseEntity.ok(service.selectAll());
    }

    @GetMapping("/{id}")
    public Filme getByid(@PathVariable Long id){
        return service.select(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping
    public Filme post(@RequestBody Filme filme){
            return service.create(filme);
    }

    @PutMapping
    public Filme put(@RequestBody Filme filme){
            return service.create(filme);
    }
}
