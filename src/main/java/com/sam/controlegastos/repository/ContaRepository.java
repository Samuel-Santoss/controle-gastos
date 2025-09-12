package com.sam.controlegastos.repository;

import com.sam.controlegastos.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface ContaRepository extends JpaRepository <Conta, Long> {
    //Busca contas, por intervalo
    List<Conta> findByDataBetween(LocalDate inicio, LocalDate fim);
}
