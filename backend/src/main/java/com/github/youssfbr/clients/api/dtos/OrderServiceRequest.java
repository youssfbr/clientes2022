package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderServiceRequest {

    private String description;
    private BigDecimal price;
    private String note;
    private Long clientId;

}
