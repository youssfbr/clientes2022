package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.*;
import com.github.youssfbr.clients.api.mappers.DeviceClientMapper;
import com.github.youssfbr.clients.domain.entities.DeviceClient;
import com.github.youssfbr.clients.domain.repositories.IDeviceClientRepository;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceClientService implements IDeviceClientService {

    private final IDeviceClientRepository deviceClientRepository;
    private final DeviceClientMapper deviceClientMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DeviceClientResponse> listAll() {
        return deviceClientRepository.findAll()
                .stream()
                .map(deviceClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceClientResponse findById(Long deviceClientId) {
        return deviceClientRepository.findById(deviceClientId)
                .map(deviceClientMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public MessageResponseDTO createDeviceClient(DeviceClientRequest deviceClientRequest) {

        DeviceClient deviceClientToCreate = deviceClientMapper.toModel(deviceClientRequest);
        DeviceClient createdDeviceClient = deviceClientRepository.save(deviceClientToCreate);

        return createMessageResponse("Equipamento do cliente criado com ID ", createdDeviceClient.getId());
    }

    @Override
    @Transactional
    public MessageResponseDTO updateDeviceClient(Long deviceClientId, DeviceClientRequest deviceClientRequest) {

        findById(deviceClientId);

        DeviceClient deviceClientToUpdate = deviceClientMapper.toModel(deviceClientRequest);
        deviceClientToUpdate.setId(deviceClientId);
        DeviceClient updatedDeviceClient = deviceClientRepository.save(deviceClientToUpdate);

        return createMessageResponse("Cliente atualizado com ID ", updatedDeviceClient.getId());
    }

    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
