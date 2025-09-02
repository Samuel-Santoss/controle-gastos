package com.sam.controlegastos.repository;

import com.sam.controlegastos.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository <Conta, Long> {
}
