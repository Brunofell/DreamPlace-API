package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.domain.Avaliar;
import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.exceptions.ObjectNotFoundException;
import com.DreamPlace.DreamPlace.repository.AvaliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliarService {

    @Autowired
    private AvaliarRepository repository;

    @Autowired
    private CadastroService cadastroService;


    public Avaliar findById(Integer id){
        Optional<Avaliar> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Avaliar.class.getName()));
    }

    public List<Avaliar> findAll(Integer id_cad){
        cadastroService.findById(id_cad);
        return repository.findAllByCadastro(id_cad);
    }

    public Avaliar update(Integer id, Avaliar obj){
        Avaliar newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }


    private void updateData(Avaliar newObj, Avaliar obj) {
        newObj.setNome(obj.getNome());
        newObj.setNumero(obj.getNumero());
        newObj.setEmail(obj.getNome());
        newObj.setNota(obj.getNota());
    }


    public Avaliar create(Integer id_Cad, Avaliar obj) {
        obj.setId(null);
        Cadastro cad = cadastroService.findById(id_Cad);
        obj.setCadastro(cad);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Avaliar obj = findById(id);
        repository.delete(obj);
    }
}
