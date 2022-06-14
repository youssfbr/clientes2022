package com.github.youssfbr.clients.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.youssfbr.clients.domain.entities.enums.StatusOrderService;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderServiceResponse {

    private Long id;
    private OffsetDateTime openDate;
    private StatusOrderService statusOrderService;
    private DeviceClientResponse device;
    private String claimedDefect;
    private String solutionDefect;
    private String description;
    private BigDecimal price;
    private String note;
    private OffsetDateTime completionDate;

}
