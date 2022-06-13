package com.github.youssfbr.clients.api.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DeviceRequest {

    @NotBlank
    @Size(max = 20)
    private String name;

}
