package com.sam.controlegastos.service;


import com.sam.controlegastos.dto.ContaResponseDTO;
import com.sam.controlegastos.dto.ContaUpdateDTO;
import com.sam.controlegastos.model.Conta;
import com.sam.controlegastos.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

        // Validar descrição
        else if (conta.getDescricao() == null || conta.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória");
        }
        // Validar valor
        if (conta.getValor() == null) {
            throw new IllegalArgumentException("Valor é obrigatório");
        }
        if (conta.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        // Tratar dataCadastro
         if (conta.getDataCadastro() == null) {
             conta.setDataCadastro(LocalDate.now());
         }
        // Garantir que não persistimos um id enviado pelo cliente
            conta.setId(null);

        return contaRepository.save(conta);
    }

    // Editar uma conta existente
    public Conta editarConta(Long id, Conta conta) {
        // Buscar conta existente
        Conta contaExistente = contaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada, digite novamente."));

        // Validar descrição
        if (contaExistente.getDescricao() == null || conta.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória!");
        }

        // Validar valor
        if (contaExistente.getValor() == null) {
            throw new IllegalArgumentException("Valor é obrigatório!");
        }
        if (contaExistente.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero!");
        }

        // Atualizar os dados
        contaExistente.setDescricao(conta.getDescricao());
        contaExistente.setValor(conta.getValor());

        // Salvar no banco
        return contaRepository.save(contaExistente);
    }

    // Excluir uma conta pelo ID
    public void excluirConta(Long id) {
        if (contaRepository.existsById(id)) {
            contaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Conta não encontrada");
        }
    }

    public ContaResponseDTO atualizarConta (Long id, ContaUpdateDTO dto) {
        Conta   contaExistente = contaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Conta não encontrada, com Id " +id));

        contaExistente.setDescricao(dto.getDescricao());
        contaExistente.setValor(dto.getValor());
        contaExistente.setDataCadastro(dto.getDataCadastro());

        Conta contaAtualiza = contaRepository.save(contaExistente);
        return new ContaResponseDTO(contaAtualiza);

    }
    // Listar todas as contas
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    // Buscar por Id
    public Conta buscarPorId (Long id){
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não localizada com id " + id));
    }

    // Resumo mensal (valor total gasto em um mês)
    public Map<String, Object> resumoMensal(int ano, int mes) {
        BigDecimal total = contaRepository.findAll().stream()
                .filter(c -> c.getDataCadastro() != null
                        && c.getDataCadastro().getYear() == ano
                        && c.getDataCadastro().getMonthValue() == mes)
                .map(Conta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> resumo = new HashMap<>();
        resumo.put("ano", ano);
        resumo.put("mes", mes);
        resumo.put("total", total);
        return resumo;
    }
}
