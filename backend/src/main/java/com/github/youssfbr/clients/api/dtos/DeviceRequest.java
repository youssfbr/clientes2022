package com.github.youssfbr.clients.api.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class DeviceRequest {

    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String name;

}
