package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.*;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "Tipo de Equipamento")
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private final IDeviceService deviceService;

    @GetMapping
    @ApiOperation("Listar tipos de equipamentos")
    public List<DeviceResponse> listall() {
        return deviceService.listAll();
    }

    @GetMapping("{deviceId}")
    @ApiOperation("Listar tipos de equipamentos pelo código")
    public DeviceResponse findById(@PathVariable Long deviceId) {
        return deviceService.listById(deviceId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Criar um tipo de equipamento")
    public MessageResponseDTO createDevice(@RequestBody @Valid DeviceRequest deviceRequest) {
        return deviceService.createDevice(deviceRequest);
    }

}
