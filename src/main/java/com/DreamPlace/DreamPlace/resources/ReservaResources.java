package com.DreamPlace.DreamPlace.resources;

import com.DreamPlace.DreamPlace.DTOs.ReservaDTO;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.services.ReservaService;
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
@RequestMapping("/reservas") //value =
public class ReservaResources {

    @Autowired
    private ReservaService service;


    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Integer id){
        Reserva obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // So vai achar livros pela categoria, omite o autor e texto: localhost:8080/livros?categoria=1
    @GetMapping // PRO PADRAO DTO.
    public ResponseEntity<List<ReservaDTO>> findAll(
            @RequestParam(value = "categoria", defaultValue = "0") Integer id_cad){
        List<Reserva> list = service.findAll(id_cad);
        List<ReservaDTO> listDTO = list.stream().map(obj -> new ReservaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Integer id, @Valid @RequestBody Reserva obj){
        Reserva newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Reserva> updatePatch(@PathVariable Integer id, @Valid @RequestBody Reserva obj){
        Reserva newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Reserva> create(
            @RequestParam(value = "cadastro", defaultValue = "0") Integer id_cad, @Valid @RequestBody Reserva obj){
        Reserva newObj = service.create(id_cad, obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/reservas/{id}")
                .buildAndExpand(newObj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
