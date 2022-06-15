package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.DeviceBrandRequest;
import com.github.youssfbr.clients.api.dtos.DeviceBrandResponse;
import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.domain.services.interfaces.IDeviceBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@Api(tags = "Marca do equipamento")
@RequiredArgsConstructor
public class DeviceBrandController {

    private final IDeviceBrandService deviceBrandService;

    @GetMapping
    @ApiOperation("Listar marcas dos equipamentos")
    public List<DeviceBrandResponse> listall() {
        return deviceBrandService.listAll();
    }

    @GetMapping("{brandId}")
    @ApiOperation("Buscar marca do equipamento pelo código")
    public DeviceBrandResponse listById(@PathVariable Long brandId) {
        return deviceBrandService.findById(brandId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Criar uma marca de um equipamento")
    public MessageResponseDTO createDeviceBrand(@RequestBody @Valid DeviceBrandRequest deviceBrandRequest) {
        return deviceBrandService.createDeviceBrand(deviceBrandRequest);
    }

}
