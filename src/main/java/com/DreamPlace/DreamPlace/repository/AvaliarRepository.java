package com.DreamPlace.DreamPlace.repository;

import com.DreamPlace.DreamPlace.domain.Avaliar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliarRepository extends JpaRepository<Avaliar, Integer> {
    @Query("SELECT obj FROM Avaliar obj WHERE obj.cadastro.id = :id_cad ORDER BY nome")
    List<Avaliar> findAllByCadastro(@Param(value ="id_cad") Integer idCad);
}
