package com.example.projeto01.service;

import com.example.projeto01.DTO.PessoaRequest;
import com.example.projeto01.DTO.PessoaResponse;
import com.example.projeto01.model.Pessoa;
import com.example.projeto01.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return new PessoaResponse(salvaPessoa.getId(), salvaPessoa.getNome(), salvaPessoa.getIdade());
    }

    public List<PessoaResponse> listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream()
                .map(p -> new PessoaResponse(p.getId(), p.getNome(), p.getIdade()))
                .collect(Collectors.toList());
    }

    public String deletar(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new RuntimeException("Pessoa com ID " + id + " não encontrada.");
        }

        pessoaRepository.deleteById(id);
        return "Pessoa com o ID " + id + " foi deletada com sucesso!";
    }


}
