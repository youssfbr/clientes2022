package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.DeviceClientRequest;
import com.github.youssfbr.clients.api.dtos.DeviceClientResponse;
import com.github.youssfbr.clients.domain.entities.DeviceClient;
import com.github.youssfbr.clients.domain.repositories.IClientRepository;
import com.github.youssfbr.clients.domain.repositories.IDeviceBrandRepository;
import com.github.youssfbr.clients.domain.repositories.IDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeviceClientMapper {

    private final IClientRepository clientRepository;
    private final IDeviceRepository deviceRepository;
    private final IDeviceBrandRepository deviceBrandRepository;
    private final ClientMapper clientMapper;
    private final DeviceMapper deviceMapper;
    private final DeviceBrandMapper deviceBrandMapper;


    public DeviceClientResponse toDTO(DeviceClient deviceClient) {
        return DeviceClientResponse.builder()
                .id(deviceClient.getId())
                .client(clientMapper.toDTO(deviceClient.getClient()))
                .deviceType(deviceMapper.toDTO(deviceClient.getDevice()))
                .deviceBrand(deviceBrandMapper.toDTO(deviceClient.getDeviceBrand()))
                .model(deviceClient.getModel())
                .serial(deviceClient.getSerial())
                .configuration(deviceClient.getConfiguration())
                .voltage(deviceClient.getVoltage())
                .note(deviceClient.getNote())
                .dateRegister(deviceClient.getDateRegister())
                .build();
    }

    public DeviceClient toModel(DeviceClientRequest deviceClientRequest) {
        return DeviceClient.builder()
                .client(clientRepository.findByIdOrElseThrow(deviceClientRequest.getClientId()))
                .device(deviceRepository.findByIdOrElseThrow(deviceClientRequest.getDeviceId()))
                .deviceBrand(deviceBrandRepository.findByIdOrElseThrow(deviceClientRequest.getDeviceBrandId()))
                .model(deviceClientRequest.getModel())
                .serial(deviceClientRequest.getSerial())
                .configuration(deviceClientRequest.getConfiguration())
                .voltage(deviceClientRequest.getVoltage())
                .note(deviceClientRequest.getNote())
                .build();
    }

}
