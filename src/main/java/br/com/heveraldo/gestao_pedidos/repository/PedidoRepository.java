package br.com.heveraldo.gestao_pedidos.repository;

import br.com.heveraldo.gestao_pedidos.model.CentroDistribuicao;
import br.com.heveraldo.gestao_pedidos.model.Pedido;
import br.com.heveraldo.gestao_pedidos.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    
    List<Pedido> findByStatus(StatusPedido status);

    List<Pedido> findByCliente_CentroDistribuicaoAndStatus(CentroDistribuicao centroDistribuicao, StatusPedido status);

    @Query("SELECT DISTINCT p.cliente.centroDistribuicao FROM Pedido p WHERE p.status = :status")
    List<CentroDistribuicao> findDistinctCDsComPedidosPendentes(StatusPedido status);
}