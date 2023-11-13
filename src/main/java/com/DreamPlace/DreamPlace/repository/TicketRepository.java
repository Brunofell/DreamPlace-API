package com.DreamPlace.DreamPlace.repository;

import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT obj FROM Ticket obj WHERE obj.cadastro.id = :id_cad ORDER BY nome")
    List<Ticket> findAllByCadastro(@Param(value ="id_cad") Integer idCad);
}
