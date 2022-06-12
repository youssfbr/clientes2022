package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DeviceBrandResponse {

    private Long id;
    private String name;

}
