package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeviceClientResponse {

    private Long id;
    private ClientResponse client;
    private DeviceResponse device;
    private DeviceBrandResponse deviceBrand;
    private String model;
    private String serial;
    private String note;
    private LocalDate dateRegister;

}
