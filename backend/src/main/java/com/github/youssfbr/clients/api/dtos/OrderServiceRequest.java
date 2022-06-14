package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
public class OrderServiceRequest {

    @NotNull
    @Positive
    private Long deviceId;

    private String claimedDefect;
    private String solutionDefect;
    private String description;
    private BigDecimal price;
    private String note;

}
