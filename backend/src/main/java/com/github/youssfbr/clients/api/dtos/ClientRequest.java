package com.github.youssfbr.clients.api.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequest {

    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String note;

}
