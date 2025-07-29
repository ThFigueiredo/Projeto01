package com.example.projeto01.DTO;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

    private Long id;
    private String nome;
    private int idade;

}
