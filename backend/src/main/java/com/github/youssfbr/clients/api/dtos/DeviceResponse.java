package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DeviceResponse {

    private Long id;
    private String name;

}
