package com.DreamPlace.DreamPlace.repository;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
}
