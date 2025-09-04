package com.sam.controlegastos.service;


import com.sam.controlegastos.model.Conta;
import com.sam.controlegastos.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public Conta inserirConta(Conta conta) {
        // 1) Verificar se o objeto conta não é nulo
        if (conta == null) {
            throw new IllegalArgumentException("Conta não informada");
        }

        // 2) Validar descrição
        else if (conta.getDescricao() == null || conta.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória");
        }
        // 3) Validar valor
        if (conta.getValor() == null)
            throw new IllegalArgumentException("Valor é obrigatório");
        if (conta.getValor().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Valor deve ser maior que zero");

        // 4) Tratar dataCadastro
         if (conta.getDataCadastro() == null)
             conta.setDataCadastro(LocalDate.now());

        // 5) Garantir que não persistimos um id enviado pelo cliente
            conta.setId(null);

        return contaRepository.save(conta);
    }

    // Editar uma conta existente
    public Conta editarConta(Long id, Conta conta) {
        // lógica depois
        return null;
    }

    // Excluir uma conta pelo ID
    public void excluirConta(Long id) {
        // TODO: implementar exclusão depois
    }

    // Listar todas as contas
    public List<Conta> listarContas() {
        // lógica depois
        return null;
    }

    // Resumo mensal (valor total gasto em um mês)
    public BigDecimal resumoMensal(int ano, int mes) {
        // lógica depois
        return null;
    }
}
