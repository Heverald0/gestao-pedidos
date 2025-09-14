package br.com.heveraldo.gestao_pedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String razaoSocial;
    private String cnpj;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CentroDistribuicao centroDistribuicao;
}