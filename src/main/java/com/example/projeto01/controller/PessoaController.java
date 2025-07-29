package com.example.projeto01.controller;


import com.example.projeto01.DTO.PessoaRequest;
import com.example.projeto01.DTO.PessoaResponse;
import com.example.projeto01.service.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


