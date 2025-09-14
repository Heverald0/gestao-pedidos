package br.com.heveraldo.gestao_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String cnh;
    private boolean disponivel = true;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private CentroDistribuicao centroDistribuicao;
}