package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.domain.Ticket;
import com.DreamPlace.DreamPlace.exceptions.ObjectNotFoundException;
import com.DreamPlace.DreamPlace.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;
    @Autowired
    private CadastroService cadastroService;

    public Ticket findById(Integer id){
        Optional<Ticket> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: " + id + ", Tipo: " + Ticket.class.getName()));
    }

    public List<Ticket> findAll(Integer id_cad){
        cadastroService.findById(id_cad);
        return repository.findAllByCadastro(id_cad);
    }

    public Ticket update(Integer id, Ticket obj){
        Ticket newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }


    private void updateData(Ticket newObj, Ticket obj) {
        newObj.setNome(obj.getNome());
        newObj.setCpf(obj.getCpf());
        newObj.setTicket(obj.getTicket());
    }


    public Ticket create(Integer id_Cad, Ticket obj) {
        obj.setId(null);
        Cadastro cad = cadastroService.findById(id_Cad);
        obj.setCadastro(cad);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Ticket obj = findById(id);
        repository.delete(obj);
    }

}
