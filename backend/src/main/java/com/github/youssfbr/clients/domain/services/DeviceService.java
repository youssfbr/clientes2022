package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.DeviceRequest;
import com.github.youssfbr.clients.api.dtos.DeviceResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.mappers.DeviceMapper;
import com.github.youssfbr.clients.domain.entities.Device;
import com.github.youssfbr.clients.domain.repositories.IDeviceRepository;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService implements IDeviceService {

    private final IDeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;


    @Override
    @Transactional(readOnly = true)
    public List<DeviceResponse> listAll() {
        return deviceRepository.findAll()
                .stream()
                .map(deviceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceResponse listById(Long deviceId) {
        return deviceRepository.findById(deviceId)
                .map(deviceMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @Override
    @Transactional
    public MessageResponseDTO createDevice(DeviceRequest deviceRequest) {

        Device deviceToCreate = deviceMapper.toModel(deviceRequest);
        Device createdDevice = deviceRepository.save(deviceToCreate);

        return createMessageResponse("Dispositivo criado com ID ", createdDevice.getId());
    }
    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
