package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.DTOs.CadastroDTO;
import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.exceptions.DataIntegrityViolationException;
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


    public Cadastro create(Cadastro obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Cadastro update(Integer id, CadastroDTO objDTO) {
        Cadastro obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setEmail(objDTO.getEmail());
        obj.setSenha(objDTO.getSenha());
        obj.setNumero(objDTO.getNumero());
        obj.setCpf(objDTO.getCpf());
        return repository.save(obj);
    }


    public void delete(Integer id) {
        findById(id);
        try{
            repository.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "User não pode ser deletado! Possui reservas associadas.");
        }

    }

    public Cadastro fazerLogin(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }


}
