package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;

import java.util.List;

public interface IClientService {

    List<ClientResponse> listAll();
    List<ClientResponse> findByNameContaining(String name);
    ClientResponse findById(Long id);
    MessageResponseDTO createClient(ClientRequest clientRequest);
    MessageResponseDTO updateClient(Long clientId, ClientRequest clientRequest);

}
