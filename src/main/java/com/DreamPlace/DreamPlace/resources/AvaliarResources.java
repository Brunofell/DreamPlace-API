package com.DreamPlace.DreamPlace.resources;

import com.DreamPlace.DreamPlace.DTOs.AvaliarDTO;
import com.DreamPlace.DreamPlace.DTOs.ReservaDTO;
import com.DreamPlace.DreamPlace.domain.Avaliar;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.services.AvaliarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200") // vai ter que trocar
@RestController
@RequestMapping("/avaliar")
public class AvaliarResources {

    @Autowired
    private AvaliarService service;

    @GetMapping("/{id}")
    public ResponseEntity<Avaliar> findById(@PathVariable Integer id){
        Avaliar obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping // PRO PADRAO DTO.
    public ResponseEntity<List<AvaliarDTO>> findAll(
            @RequestParam(value = "cadastro", defaultValue = "0") Integer id_cad){
        List<Avaliar> list = service.findAll(id_cad);
        List<AvaliarDTO> listDTO = list.stream().map(obj -> new AvaliarDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Avaliar> update(@PathVariable Integer id, @Valid @RequestBody Avaliar obj){
        Avaliar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Avaliar> updatePatch(@PathVariable Integer id, @Valid @RequestBody Avaliar obj){
        Avaliar newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    // localhost:8080/avaliar?cadastro=id
    @PostMapping
    public ResponseEntity<Avaliar> create(
            @RequestParam(value = "cadastro", defaultValue = "0") Integer id_cad, @Valid @RequestBody Avaliar obj){
        Avaliar newObj = service.create(id_cad, obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/avaliar/{id}")
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
