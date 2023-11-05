package com.DreamPlace.DreamPlace.resources;

import com.DreamPlace.DreamPlace.DTOs.CadastroDTO;
import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/cadastro")
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


}
