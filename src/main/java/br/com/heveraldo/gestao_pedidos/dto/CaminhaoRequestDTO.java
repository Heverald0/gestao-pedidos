package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class CaminhaoRequestDTO {
    private String placa;
    private double capacidadePesoKg;
    private double capacidadeVolumeM3;
    private UUID centroDistribuicaoId;
}