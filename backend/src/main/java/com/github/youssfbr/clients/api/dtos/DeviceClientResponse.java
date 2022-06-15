package com.github.youssfbr.clients.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

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
    private String configuration;
    private String voltage;
    private String note;
    private OffsetDateTime dateRegister;

}
