package com.sam.controlegastos.controller;

import com.sam.controlegastos.dto.ContaCreateDTO;
import com.sam.controlegastos.dto.ContaResponseDTO;
import com.sam.controlegastos.model.Conta;
import com.sam.controlegastos.service.ContaService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<ContaResponseDTO> inserirConta(@Valid @RequestBody ContaCreateDTO dto){
        Conta conta = new Conta();
        conta.setDescricao(dto.getDescricao());
        conta.setValor(dto.getValor());
        conta.setDataCadastro(dto.getDataCadastro());

        //Inserir conta no banco
        Conta contaSalva = contaService.inserirConta(conta);

        //Converte em DTO
        ContaResponseDTO responseDTO = new ContaResponseDTO(contaSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @GetMapping
    public ResponseEntity <List<ContaResponseDTO>> listarContas(){

        //Busca todas as contas
        List<Conta> contas = contaService.listarContas();

        // Converte em ContaResponseDTO
        List<ContaResponseDTO> contasDTO = contas.stream()
                .map(ContaResponseDTO :: new)
                .toList();

        //Retorna 200, com lista em DTO
        return ResponseEntity.ok(contasDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity <ContaResponseDTO>  buscaPorId (@PathVariable Long id){

        Conta conta = contaService.buscarPorId(id);

        //Converter em DTO
        ContaResponseDTO dto = new ContaResponseDTO(conta);

        return ResponseEntity.ok(dto);
    }
}
