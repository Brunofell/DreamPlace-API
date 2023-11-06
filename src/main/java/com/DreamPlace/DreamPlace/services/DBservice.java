package com.DreamPlace.DreamPlace.services;

import com.DreamPlace.DreamPlace.domain.Cadastro;
import com.DreamPlace.DreamPlace.domain.Reserva;
import com.DreamPlace.DreamPlace.repository.CadastroRepository;
import com.DreamPlace.DreamPlace.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private ReservaRepository reservaRepository;
    public void instanciaBaseDeDados(){
        Cadastro cad1 = new Cadastro(null, "Bruno Feliciano", "brunofelimarti@gmail.com", "senha123", "12345678911", "41999702637");
        Cadastro cad2 = new Cadastro(null, "Gabrielle Feliciano", "sorvete@gmail.com", "senha123", "12345678911", "41999702637");
        Cadastro cad3 = new Cadastro(null, "Nilson Jorge", "gmail@gmail.com", "senha123", "12345678911", "41999702637");
        Cadastro cad4 = new Cadastro(null, "Idalina de Fátima", "sla@gmail.com", "senha123", "12345678911", "41999702637");

//        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren ipsum", cat1);
//        Livro l2 = new Livro(null, "Java", "Robert Martin", "Loren ipsum", cat1);
//        Livro l3 = new Livro(null, "Alan Turing", "Robert Martin", "Loren ipsum", cat3);
//        Livro l4 = new Livro(null, "I, Robot", "Robert Martin", "Loren ipsum", cat2);

        Reserva r1 = new Reserva(null, "Bruno Feliciano", "email@gmail.com", "41999702637", "14/08/24", "16/89/56", "DUPLO", "Credito", cad1 );

//        cat1.getLivros().addAll(Arrays.asList(l1));

        this.cadastroRepository.saveAll(Arrays.asList(cad1, cad2, cad3, cad4));
        this.reservaRepository.saveAll(Arrays.asList(r1));

//        this.livroRepository.saveAll(Arrays.asList(l1,l2, l3, l4));
    }


}