package com.github.youssfbr.clients.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceClientResponse {

    private Long id;
    private ClientResponse client;
    private DeviceResponse deviceType;
    private DeviceBrandResponse deviceBrand;
    private String model;
    private String serial;
    private String note;
    private LocalDate dateRegister;

}
