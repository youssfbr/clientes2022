package com.github.youssfbr.clients.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String note;
    private OffsetDateTime dateRegister;

}
