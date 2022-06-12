package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.*;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/device-clients")
@RequiredArgsConstructor
public class DeviceClientController {

    private final IDeviceClientService deviceClientService;

    @GetMapping
    public List<DeviceClientResponse> listall() {
        return deviceClientService.listAll();
    }

    @GetMapping("{deviceClientId}")
    public DeviceClientResponse findById(@PathVariable Long deviceClientId) {
        return deviceClientService.findById(deviceClientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid DeviceClientRequest deviceClientRequest) {
        return deviceClientService.createDeviceClient(deviceClientRequest);
    }

    @PutMapping("{deviceClientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO updateClient(@PathVariable Long deviceClientId, @RequestBody @Valid DeviceClientRequest deviceClientRequest) {
        return deviceClientService.updateDeviceClient(deviceClientId, deviceClientRequest);
    }

}
