package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.DeviceBrandRequest;
import com.github.youssfbr.clients.api.dtos.DeviceBrandResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;

import java.util.List;

public interface IDeviceBrandService {

    List<DeviceBrandResponse> listAll();
    DeviceBrandResponse findById(Long brandId);
    MessageResponseDTO createDeviceBrand(DeviceBrandRequest deviceBrandRequest);

}
