package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.exceptions.ObjectNotFoundException;
import com.DreamPlace.DreamPlace.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository repository;

    public Cadastro findById(Integer id){
        Optional<Cadastro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Cadastro.class.getName()));
    }

    public List<Cadastro> findAll(){
        return repository.findAll();
    }


}
