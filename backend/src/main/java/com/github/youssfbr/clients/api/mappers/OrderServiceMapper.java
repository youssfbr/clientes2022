package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.OrderServiceRequest;
import com.github.youssfbr.clients.api.dtos.OrderServiceResponse;
import com.github.youssfbr.clients.domain.entities.OrderService;
import com.github.youssfbr.clients.domain.repositories.IDeviceClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceMapper {

    private final IDeviceClientRepository deviceClientRepository;
    private final DeviceClientMapper deviceClientMapper;

    public OrderServiceResponse toDTO(OrderService orderService) {
        return OrderServiceResponse.builder()
                .id(orderService.getId())
                .openDate(orderService.getOpenDate())
                .statusOrderService(orderService.getStatusOrderService())
                .device(deviceClientMapper.toDTO(orderService.getDeviceClient()))

                .claimedDefect(orderService.getClaimedDefect())
                .description(orderService.getDescription())
                .foundDefect(orderService.getFoundDefect())
                .solutionDefect(orderService.getSolutionDefect())
                .price(orderService.getPrice())
                .note(orderService.getNote())
                .completionDate(orderService.getCompletionDate())
                .build();
    }

    public OrderService toModel(OrderServiceRequest orderServiceRequest) {
        return OrderService.builder()
                .deviceClient(deviceClientRepository.findByIdOrElseThrow(orderServiceRequest.getDeviceId()))
                .claimedDefect(orderServiceRequest.getClaimedDefect())
                .description(orderServiceRequest.getDescription())
                .solutionDefect(orderServiceRequest.getSolutionDefect())
                .solutionDefect(orderServiceRequest.getSolutionDefect())
                .price(orderServiceRequest.getPrice())
                .note(orderServiceRequest.getNote())
                .build();
    }

}
