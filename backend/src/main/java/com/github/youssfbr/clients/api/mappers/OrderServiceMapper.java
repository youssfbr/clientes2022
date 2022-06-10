package com.github.youssfbr.clients.api.mappers;

import com.github.youssfbr.clients.api.dtos.OrderServiceRequest;
import com.github.youssfbr.clients.api.dtos.OrderServiceResponse;
import com.github.youssfbr.clients.domain.entities.OrderService;
import com.github.youssfbr.clients.domain.repositories.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceMapper {

    private final IClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public OrderServiceResponse toDTO(OrderService orderService) {
        return OrderServiceResponse.builder()
                .id(orderService.getId())
                .description(orderService.getDescription())
                .price(orderService.getPrice())
                .note(orderService.getNote())
                .client(clientMapper.toDTO(orderService.getClient()))
                .build();
    }

    public OrderService toModel(OrderServiceRequest orderServiceRequest) {
        return OrderService.builder()
                .description(orderServiceRequest.getDescription())
                .price(orderServiceRequest.getPrice())
                .note(orderServiceRequest.getNote())
                .client(clientRepository.findByIdOrElseThrow(orderServiceRequest.getClientId()))
                .build();
    }

}
