package com.github.youssfbr.clients.api.controller;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.dtos.OrderServiceRequest;
import com.github.youssfbr.clients.api.dtos.OrderServiceResponse;
import com.github.youssfbr.clients.api.mappers.OrderServiceMapper;
import com.github.youssfbr.clients.domain.services.interfaces.IOrderServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order-services")
@RequiredArgsConstructor
public class OrderServiceController {

    private final IOrderServiceService orderService;
    private final OrderServiceMapper orderServiceMapper;

    @GetMapping
    public List<OrderServiceResponse> listall() {
        return orderService.listAllOrderServices();
    }

    @GetMapping("{orderServiceId}")
    public OrderServiceResponse listById(@PathVariable Long orderServiceId) {
        return orderService.listByIdOrderService(orderServiceId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createOrderService(@RequestBody @Valid OrderServiceRequest orderServiceRequest) {
        return orderService.createOrderService(orderServiceRequest);
    }

}
