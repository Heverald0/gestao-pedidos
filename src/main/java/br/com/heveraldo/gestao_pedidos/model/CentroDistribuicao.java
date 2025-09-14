package br.com.heveraldo.gestao_pedidos.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID; 

@Entity
@Getter
@Setter
public class CentroDistribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private UUID id; 

    private String nome;

    @Embedded
    private Endereco endereco;
}