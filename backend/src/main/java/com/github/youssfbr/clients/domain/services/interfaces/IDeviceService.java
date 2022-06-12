package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.DeviceRequest;
import com.github.youssfbr.clients.api.dtos.DeviceResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;

import java.util.List;

public interface IDeviceService {

    List<DeviceResponse> listAll();
    DeviceResponse listById(Long deviceId);
    MessageResponseDTO createDevice(DeviceRequest deviceRequest);

}
