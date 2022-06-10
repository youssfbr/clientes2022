package com.github.youssfbr.clients.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String note;
    private LocalDate dateRegister;

}
