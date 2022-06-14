package com.github.youssfbr.clients.domain.services;

import com.github.youssfbr.clients.api.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.api.dtos.OrderServiceRequest;
import com.github.youssfbr.clients.api.dtos.OrderServiceResponse;
import com.github.youssfbr.clients.api.mappers.OrderServiceMapper;
import com.github.youssfbr.clients.domain.entities.OrderService;
import com.github.youssfbr.clients.domain.repositories.IOrderServiceRepository;
import com.github.youssfbr.clients.domain.services.interfaces.IOrderServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceService implements IOrderServiceService {

    private final IOrderServiceRepository orderServiceRepository;
    private final OrderServiceMapper orderServiceMapper;
    private static final String MESSAGE = "Ordem de Serviço criada com ID ";

    @Override
    @Transactional(readOnly = true)
    public List<OrderServiceResponse> listAllOrderServices() {
        return orderServiceRepository.findAll()
                .stream()
                .map(orderServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderServiceResponse listByIdOrderService(Long orderServiceId) {
        return orderServiceRepository.findById(orderServiceId)
                .map(orderServiceMapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    @Transactional
    public MessageResponseDTO createOrderService(OrderServiceRequest orderServiceRequest) {

        OrderService orderServiceToCreate = orderServiceMapper.toModel(orderServiceRequest);
        OrderService createdOrderService = orderServiceRepository.save(orderServiceToCreate);

        return createMessageResponse(createdOrderService.getId());
    }

    private MessageResponseDTO createMessageResponse(final Long id) {
        return MessageResponseDTO
                .builder()
                .message(MESSAGE + id)
                .build();
    }

}
