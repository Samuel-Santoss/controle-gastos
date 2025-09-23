package com.sam.controlegastos.dto;

import com.sam.controlegastos.model.Conta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaResponseDTO {

    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate dataCadastro;

    public ContaResponseDTO(Long id, String descricao, BigDecimal valor, LocalDate dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }

    public ContaResponseDTO() {
    }

    public ContaResponseDTO (Conta conta){
        this.id = conta.getId();
        this.descricao = conta.getDescricao();
        this.valor = conta.getValor();
        this.dataCadastro = conta.getDataCadastro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
