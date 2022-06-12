package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.*;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final IDeviceService deviceService;

    @GetMapping
    public List<DeviceResponse> listall() {
        return deviceService.listAll();
    }

    @GetMapping("{clientId}")
    public DeviceResponse findById(@PathVariable Long clientId) {
        return deviceService.listById(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDevice(@RequestBody @Valid DeviceRequest deviceRequest) {
        return deviceService.createDevice(deviceRequest);
    }

}
