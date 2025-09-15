package br.com.heveraldo.gestao_pedidos.service;

import br.com.heveraldo.gestao_pedidos.dto.MotoristaRequestDTO;
import br.com.heveraldo.gestao_pedidos.model.CentroDistribuicao;
import br.com.heveraldo.gestao_pedidos.model.Motorista;
import br.com.heveraldo.gestao_pedidos.repository.CentroDistribuicaoRepository;
import br.com.heveraldo.gestao_pedidos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private CentroDistribuicaoRepository cdRepository;

    public Motorista criarMotorista(MotoristaRequestDTO dto) {
        CentroDistribuicao cd = cdRepository.findById(dto.getCentroDistribuicaoId())
                .orElseThrow(() -> new RuntimeException("Centro de Distribuição não encontrado"));

        Motorista novoMotorista = new Motorista();
        novoMotorista.setNome(dto.getNome());
        novoMotorista.setCnh(dto.getCnh());
        novoMotorista.setCentroDistribuicao(cd);
        novoMotorista.setDisponivel(true);

        return motoristaRepository.save(novoMotorista);
    }

    public List<Motorista> listarTodos() {
        return motoristaRepository.findAll();
    }

    public Optional<Motorista> buscarPorId(UUID id) {
        return motoristaRepository.findById(id);
    }
}