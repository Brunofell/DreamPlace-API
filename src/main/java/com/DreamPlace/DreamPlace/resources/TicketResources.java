package com.DreamPlace.DreamPlace.resources;

import com.DreamPlace.DreamPlace.DTOs.ReservaDTO;
import com.DreamPlace.DreamPlace.DTOs.TicketDTO;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.domain.Ticket;
import com.DreamPlace.DreamPlace.services.TicketService;
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
@RequestMapping("/ticket") //value =
public class TicketResources {

    @Autowired
    private TicketService service;


    @GetMapping("/{id}")
    public ResponseEntity<Ticket> findById(@PathVariable Integer id){
        Ticket obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // So vai achar livros pela categoria, omite o autor e texto: localhost:8080/cadastro?ticket=1
    @GetMapping // PRO PADRAO DTO.
    public ResponseEntity<List<TicketDTO>> findAll(
            @RequestParam(value = "cadastro", defaultValue = "0") Integer id_cad){
        List<Ticket> list = service.findAll(id_cad);
        List<TicketDTO> listDTO = list.stream().map(obj -> new TicketDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@PathVariable Integer id, @Valid @RequestBody Ticket obj){
        Ticket newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ticket> updatePatch(@PathVariable Integer id, @Valid @RequestBody Ticket obj){
        Ticket newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Ticket> create(
            @RequestParam(value = "cadastro", defaultValue = "0") Integer id_cad, @Valid @RequestBody Ticket obj){
        Ticket newObj = service.create(id_cad, obj);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/ticket/{id}")
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
