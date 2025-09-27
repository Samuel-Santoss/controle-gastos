package com.sam.controlegastos.repository;

import com.sam.controlegastos.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository <Conta, Long> {
    //Busca contas, por intervalo
    List<Conta> findByDataCadastroBetween(LocalDate inicio, LocalDate fim);
}
