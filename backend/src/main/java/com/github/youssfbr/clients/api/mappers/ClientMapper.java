package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.domain.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponse toDTO(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .cpf(client.getCpf())
                .birthDate(client.getBirthDate())
                .note(client.getNote())
                .dateRegister(client.getDateRegister())
                .build();
    }

    public Client toModel(ClientRequest clientRequest) {
        return Client.builder()
              //  .id(clientRequest.getId())
                .name(clientRequest.getName())
                .email(clientRequest.getEmail())
                .cpf(clientRequest.getCpf())
                .birthDate(clientRequest.getBirthDate())
                .note(clientRequest.getNote())
                .build();
    }

}
