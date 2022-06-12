package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public List<ClientResponse> listall() {
        return clientService.listAll();
    }

    @GetMapping("/name/{clientName}")
    public List<ClientResponse> findByNameContaining(@PathVariable String clientName) {
        return clientService.findByNameContaining(clientName);
    }

    @GetMapping("{clientId}")
    public ClientResponse listById(@PathVariable Long clientId) {
        return clientService.findById(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

    @PutMapping("{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO updateClient(@PathVariable Long clientId, @RequestBody @Valid ClientRequest clientRequest) {
        return clientService.updateClient(clientId, clientRequest);
    }

}
