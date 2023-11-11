package com.DreamPlace.DreamPlace.resources;

import com.DreamPlace.DreamPlace.DTOs.CadastroDTO;
import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.services.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/cadastros")
public class CadastroResources {

    @Autowired
    private CadastroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> findById(@PathVariable Integer id){
        Cadastro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CadastroDTO>> findAll(){
        List<Cadastro> list = service.findAll();
        List<CadastroDTO> listDTO = list.stream().map(obj -> new CadastroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Cadastro> create(@Valid @RequestBody Cadastro obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroDTO> update(@Valid @PathVariable Integer id, @RequestBody CadastroDTO objDTO){
        Cadastro newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new CadastroDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
