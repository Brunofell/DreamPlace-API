package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.exceptions.ObjectNotFoundException;
import com.DreamPlace.DreamPlace.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private CadastroService cadastroService;
    public Reserva findById(Integer id){
        Optional<Reserva> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Reserva.class.getName()));
    }

    public List<Reserva> findAll(Integer id_cad){
        cadastroService.findById(id_cad);
        return repository.findAllByCadastro(id_cad);
    }

    public Reserva update(Integer id, Reserva obj){
        Reserva newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }


    private void updateData(Reserva newObj, Reserva obj) {
       newObj.setNome(obj.getNome());
       newObj.setNumero(obj.getNumero());
       newObj.setCheckIn(obj.getCheckIn());
       newObj.setCheckOut(obj.getCheckOut());
       newObj.setQuarto(obj.getQuarto());
       newObj.setPagamento(obj.getPagamento());
    }


    public Reserva create(Integer id_Cad, Reserva obj) {
        obj.setId(null);
        Cadastro cad = cadastroService.findById(id_Cad);
        obj.setCadastro(cad);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Reserva obj = findById(id);
        repository.delete(obj);
    }
}
