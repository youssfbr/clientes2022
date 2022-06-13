package com.github.youssfbr.clients.api.dtos;

import com.github.youssfbr.clients.api.controller.validators.ClientExistsById;
import com.github.youssfbr.clients.api.controller.validators.DeviceBrandExistsById;
import com.github.youssfbr.clients.api.controller.validators.DeviceExistsById;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class DeviceClientRequest {

    @NotNull
    @Positive
    @ClientExistsById
    private Long clientId;

    @NotNull
    @Positive
    @DeviceExistsById
    private Long deviceId;

    @NotNull
    @Positive
    @DeviceBrandExistsById
    private Long deviceBrandId;

    @Size(max = 20)
    private String model;

    @Size(max = 20)
    private String serial;

    private String note;
    private LocalDate dateRegister;

}
