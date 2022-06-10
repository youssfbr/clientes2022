package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{clientId}")
    public ClientResponse listById(@PathVariable Long clientId) {
        return clientService.listById(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
    }

}
