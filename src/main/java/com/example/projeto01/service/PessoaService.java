package com.example.projeto01.service;

import com.example.projeto01.DTO.PessoaRequest;
import com.example.projeto01.DTO.PessoaResponse;
import com.example.projeto01.model.Pessoa;
import com.example.projeto01.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaResponse salvar(PessoaRequest pessoaRequest) {
     Pessoa pessoa = new Pessoa();
     pessoa.setNome(pessoaRequest.getNome());
     pessoa.setIdade(pessoaRequest.getIdade());

     Pessoa salvaPessoa = pessoaRepository.save(pessoa);
     return new PessoaResponse(salvaPessoa.getId(),salvaPessoa.getNome(), salvaPessoa.getIdade());

    }



}
