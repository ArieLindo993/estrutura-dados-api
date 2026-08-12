package com.api.spring.service;

import com.api.spring.entidades.Cliente;
import com.api.spring.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //injeta a dependencia de forma automatica
public class ClienteService {

    private final ClienteRepository clienteRepository;

/* METODO HARDCODED PARA INJECAO DE DEPENCIA NO CASO CLIENTE REPOSITORY
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

 */

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
