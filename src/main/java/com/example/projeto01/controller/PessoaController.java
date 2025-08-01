package com.example.projeto01.controller;


import com.example.projeto01.DTO.PessoaRequest;
import com.example.projeto01.DTO.PessoaResponse;
import com.example.projeto01.service.PessoaService;
import jakarta.persistence.PostUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/create")
    public ResponseEntity<PessoaResponse> salvarPessoa(@RequestBody PessoaRequest pessoaRequest) {
        PessoaResponse pessoa = pessoaService.salvar(pessoaRequest);
        return ResponseEntity.ok(pessoa);
    }
    @GetMapping("/list")
    public ResponseEntity<List<PessoaResponse>> listarPessoa() {
        List<PessoaResponse> pessoas = pessoaService.listar();
        return ResponseEntity.ok(pessoas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        String mensagem = pessoaService.deletar(id);
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody PessoaRequest request) {
        String mensagem = pessoaService.atualizar(id, request);
        return ResponseEntity.ok(mensagem); // HTTP 200 OK + mensagem
    }
}


