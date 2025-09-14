package br.com.heveraldo.gestao_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Caminhao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String placa;
    private boolean disponivel = true;
    private double capacidadePesoKg;
    private double capacidadeVolumeM3;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private CentroDistribuicao centroDistribuicao;
}