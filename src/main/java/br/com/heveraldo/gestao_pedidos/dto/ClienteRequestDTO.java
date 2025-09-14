package br.com.heveraldo.gestao_pedidos.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ClienteRequestDTO {
    private String razaoSocial;
    private String cnpj;
    private EnderecoDTO endereco; 
    private UUID centroDistribuicaoId;
}