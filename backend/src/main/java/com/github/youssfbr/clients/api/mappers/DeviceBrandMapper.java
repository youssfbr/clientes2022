package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.DeviceBrandRequest;
import com.github.youssfbr.clients.api.dtos.DeviceBrandResponse;
import com.github.youssfbr.clients.domain.entities.DeviceBrand;
import org.springframework.stereotype.Component;

@Component
public class DeviceBrandMapper {

    public DeviceBrandResponse toDTO(DeviceBrand deviceBrand) {
        return DeviceBrandResponse.builder()
                .id(deviceBrand.getId())
                .name(deviceBrand.getName())
                .build();
    }

    public DeviceBrand toModel(DeviceBrandRequest deviceBrandRequest) {
        return DeviceBrand.builder()
                .name(deviceBrandRequest.getName())
                .build();
    }

}
