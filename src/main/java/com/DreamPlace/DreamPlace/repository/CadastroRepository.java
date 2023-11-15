package com.DreamPlace.DreamPlace.repository;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
    Optional<Cadastro> findByEmail(String email);

    Cadastro findByEmailAndSenha(String email, String senha);
}
