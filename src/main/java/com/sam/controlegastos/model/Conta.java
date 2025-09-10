package com.sam.controlegastos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "descricao_conta", nullable = false)
    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCadastro = LocalDate.now();

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    public Conta (){

    }
    public Conta(String descricao, BigDecimal valor, LocalDate dataCadastro){
        this.descricao = descricao;
        this.valor = valor;
        this.dataCadastro = (dataCadastro !=null) ? dataCadastro : LocalDate.now();
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
        this.dataCadastro = (dataCadastro != null) ? dataCadastro : LocalDate.now();
    }
}
