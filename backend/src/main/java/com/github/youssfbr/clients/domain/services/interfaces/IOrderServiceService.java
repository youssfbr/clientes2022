package com.github.youssfbr.clients.domain.services.interfaces;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.dtos.OrderServiceRequest;
import com.github.youssfbr.clients.api.dtos.OrderServiceResponse;

import java.util.List;

public interface IOrderServiceService {

    List<OrderServiceResponse> listAllOrderServices();
    OrderServiceResponse listByIdOrderService(Long orderServiceId);
    MessageResponseDTO createOrderService(OrderServiceRequest orderServiceRequest);

}
