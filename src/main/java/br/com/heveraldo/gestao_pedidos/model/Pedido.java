package br.com.heveraldo.gestao_pedidos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    private LocalDateTime dataCriacao;
    private LocalDateTime dataProcessamento;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private double valorTotal;
    private String tipoPagamento;
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;
}