package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.ClientRequest;
import com.github.youssfbr.clients.api.dtos.ClientResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.mappers.ClientMapper;
import com.github.youssfbr.clients.domain.entities.Client;
import com.github.youssfbr.clients.domain.repositories.IClientRepository;
import com.github.youssfbr.clients.domain.services.exceptions.EmailExistsException;
import com.github.youssfbr.clients.domain.services.interfaces.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
    private final IClientRepository clientRepository;
    private final ClientMapper clientMapper;


    @Override
    @Transactional(readOnly = true)
    public List<ClientResponse> listAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientResponse> findByNameContaining(String name) {
        return clientRepository.findByNameContaining(name)
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponse findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public MessageResponseDTO createClient(ClientRequest clientRequest) {

        checkEmail(clientRequest);

        Client clientToCreate = clientMapper.toModel(clientRequest);
        Client createdClient = clientRepository.save(clientToCreate);

        return createMessageResponse("Cliente criado com ID ", createdClient.getId());
    }

    @Override
    @Transactional
    public MessageResponseDTO updateClient(final Long clientId, final ClientRequest clientRequest) {

        findById(clientId);

        Client clientToUpdate = clientMapper.toModel(clientRequest);
        clientToUpdate.setId(clientId);
        Client updatedClient = clientRepository.save(clientToUpdate);

        return createMessageResponse("Cliente atualizado com ID ", updatedClient.getId());
    }

    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private void checkEmail(ClientRequest clientRequest) {

        boolean emailNull = clientRequest.getEmail() == null || clientRequest.getEmail().isEmpty();
        boolean cpfExists = clientRepository.existsByEmail(clientRequest.getEmail());

        if (!emailNull && cpfExists) {
            throw new EmailExistsException();
        }
    }

}
