package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.DeviceRequest;
import com.github.youssfbr.clients.api.dtos.DeviceResponse;
import com.github.youssfbr.clients.domain.entities.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {

    public DeviceResponse toDTO(Device device) {
        return DeviceResponse.builder()
                .id(device.getId())
                .name(device.getName())
                .build();
    }

    public Device toModel(DeviceRequest deviceRequest) {
        return Device.builder()
                .name(deviceRequest.getName())
                .build();
    }

}
