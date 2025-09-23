package com.sam.controlegastos.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaCreateDTO {
    @NotBlank (message = "A descrição obrigatória.")
    private String descricao;

    @NotNull
    @DecimalMin(value = "0.01", message = "O valor precisa ser maior que zero!")
    private BigDecimal valor;

    private LocalDate dataCadastro;

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
