package com.github.youssfbr.clients.api.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class DeviceClientRequest {

    @NotNull
    @Positive
    private Long clientId;

    @NotNull
    @Positive
    private Long deviceId;

    @NotNull
    @Positive
    private Long deviceBrandId;

    private String model;
    private String serial;
    private String note;
    private LocalDate dateRegister;

}
