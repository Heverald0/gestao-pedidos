package br.com.heveraldo.gestao_pedidos.model;

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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String sku;
    private double preco;
    private double pesoKg;
    private double volumeM3;
    private int unidadesPorPalete;
    private double pesoPorPaleteKg;
    private double volumePorPaleteM3;
}