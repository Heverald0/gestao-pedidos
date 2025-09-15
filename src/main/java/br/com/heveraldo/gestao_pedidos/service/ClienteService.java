package br.com.heveraldo.gestao_pedidos.service;

import br.com.heveraldo.gestao_pedidos.dto.ClienteRequestDTO;
import br.com.heveraldo.gestao_pedidos.dto.EnderecoDTO;
import br.com.heveraldo.gestao_pedidos.model.CentroDistribuicao;
import br.com.heveraldo.gestao_pedidos.model.Cliente;
import br.com.heveraldo.gestao_pedidos.model.Endereco;
import br.com.heveraldo.gestao_pedidos.repository.CentroDistribuicaoRepository;
import br.com.heveraldo.gestao_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private CentroDistribuicaoRepository cdRepository;

    public Cliente criarCliente(ClienteRequestDTO dto) {
        CentroDistribuicao cd = cdRepository.findById(dto.getCentroDistribuicaoId())
                .orElseThrow(() -> new RuntimeException("Centro de Distribuição não encontrado"));
        
        EnderecoDTO enderecoDTO = dto.getEndereco();
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCep(enderecoDTO.getCep());

        Cliente novoCliente = new Cliente();
        novoCliente.setRazaoSocial(dto.getRazaoSocial());
        novoCliente.setCnpj(dto.getCnpj());
        novoCliente.setEndereco(endereco);
        novoCliente.setCentroDistribuicao(cd);
        
        return clienteRepository.save(novoCliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteRepository.findById(id);
    }
}