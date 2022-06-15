package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.*;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "Equipamento do cliente")
@RequestMapping("/api/v1/device-clients")
public class DeviceClientController {

    private final IDeviceClientService deviceClientService;

    @GetMapping
    @ApiOperation("Listar equipamentos dos clientes")
    public List<DeviceClientResponse> listall() {
        return deviceClientService.listAll();
    }

    @GetMapping("{deviceClientId}")
    @ApiOperation("Buscar equipamento do cliente pelo código")
    public DeviceClientResponse findById(@PathVariable Long deviceClientId) {
        return deviceClientService.findById(deviceClientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Criar um equipamento de um cliente")
    public MessageResponseDTO createClient(@RequestBody @Valid DeviceClientRequest deviceClientRequest) {
        return deviceClientService.createDeviceClient(deviceClientRequest);
    }

    @PutMapping("{deviceClientId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Editar um equipamentos de um cliente")
    public MessageResponseDTO updateClient(@PathVariable Long deviceClientId, @RequestBody @Valid DeviceClientRequest deviceClientRequest) {
        return deviceClientService.updateDeviceClient(deviceClientId, deviceClientRequest);
    }

}
