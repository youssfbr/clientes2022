package com.github.youssfbr.clients.api.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ClientRequest {

    @NotNull
    @NotEmpty
    @Size(max = 60)
    private String name;

    @Email
    @Size(max = 60)
    private String email;

    @Size(max = 11)
    private String cpf;

    private LocalDate birthDate;
    private String note;

}
