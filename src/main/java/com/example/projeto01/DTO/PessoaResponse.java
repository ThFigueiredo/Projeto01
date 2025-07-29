package com.example.projeto01.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaResponse {

    private Long id;
    private String nome;
    private int idade;

}
