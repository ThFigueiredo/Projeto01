package com.example.projeto01.service;

import com.example.projeto01.DTO.PessoaRequest;
import com.example.projeto01.model.Pessoa;
import com.example.projeto01.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa salvar(PessoaRequest pessoaRequest) {
     Pessoa pessoa = new Pessoa();
     pessoa.setNome(pessoaRequest.getNome());
     pessoa.setIdade(pessoaRequest.getIdade());
     return pessoaRepository.save(pessoa);

    }



}
