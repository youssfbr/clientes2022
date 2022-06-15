package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.services.interfaces.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Clientes")
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<ClientResponse> listall() {
        return clientService.listAll();
    }

    @GetMapping("/name/{clientName}")
    @ApiOperation("Listar clientes pelo nome")
    public List<ClientResponse> findByNameContaining(@PathVariable String clientName) {
        return clientService.findByNameContaining(clientName);
    }

    @GetMapping("{clientId}")
    @ApiOperation("Buscar um cliente pelo código")
    public ClientResponse listById(@PathVariable Long clientId) {
        return clientService.findById(clientId);
    }

    @PostMapping
    @ApiOperation("Criar um cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @PutMapping("{clientId}")
    @ApiOperation("Editar um cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO updateClient(@PathVariable Long clientId, @RequestBody @Valid ClientRequest clientRequest) {
        return clientService.updateClient(clientId, clientRequest);
    }

}
