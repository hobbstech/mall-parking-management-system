package tech.hobbs.mallparkingmanagementsystem.service.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateSectionRequest {

    @NotBlank(message = "Name should be provided")
    private String name;

}
