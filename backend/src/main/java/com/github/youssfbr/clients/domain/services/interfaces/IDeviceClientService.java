package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.*;

import java.util.List;

public interface IDeviceClientService {

    List<DeviceClientResponse> listAll();
    DeviceClientResponse findById(Long deviceClientId);
    MessageResponseDTO createDeviceClient(DeviceClientRequest deviceClientRequest);
    MessageResponseDTO updateDeviceClient(Long deviceClientId, DeviceClientRequest deviceClientRequest);

}
