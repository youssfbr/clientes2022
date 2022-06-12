package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.DeviceBrandRequest;
import com.github.youssfbr.clients.api.dtos.DeviceBrandResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.mappers.DeviceBrandMapper;
import com.github.youssfbr.clients.domain.entities.DeviceBrand;
import com.github.youssfbr.clients.domain.repositories.IDeviceBrandRepository;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceBrandService implements IDeviceBrandService {

    private final IDeviceBrandRepository deviceBrandRepository;
    private final DeviceBrandMapper deviceBrandMapper;


    @Override
    @Transactional(readOnly = true)
    public List<DeviceBrandResponse> listAll() {
        return deviceBrandRepository.findAll()
                .stream()
                .map(deviceBrandMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceBrandResponse findById(Long brandId) {
        return deviceBrandRepository.findById(brandId)
                .map(deviceBrandMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public MessageResponseDTO createDeviceBrand(DeviceBrandRequest deviceBrandRequest) {

        DeviceBrand deviceBrandToCreate = deviceBrandMapper.toModel(deviceBrandRequest);
        DeviceBrand createdDeviceBrand = deviceBrandRepository.save(deviceBrandToCreate);

        return createMessageResponse("Marca criada com ID ", createdDeviceBrand.getId());
    }

    private MessageResponseDTO createMessageResponse(final String message, final Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
