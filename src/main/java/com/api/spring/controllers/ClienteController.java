package com.api.spring.controllers;

import com.api.spring.entidades.Cliente;
import com.api.spring.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/salvar-cliente")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

}
