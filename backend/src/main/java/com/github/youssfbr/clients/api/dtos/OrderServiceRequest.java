package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@Builder
public class OrderServiceRequest {

    @NotNull
    @Positive
    private Long deviceId;

    @NotBlank
    private String claimedDefect;
    private String description;
    private String foundDefect;
    private String solutionDefect;
    private BigDecimal price;
    private String note;

}
