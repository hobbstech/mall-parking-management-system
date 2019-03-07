package tech.hobbs.mallparkingmanagementsystem.service.dtos;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateParkingBayRequest {

    @NotBlank(message = "Section should be provided")
    private Long sectionId;


    @NotNull(message = "Bay number should be provided")
    @Max(value = 50, message = "Only 50 bays can fit in a section")
    @Min(value = 1, message = "Invalid bay number provided")
    private Byte bayNumber;

}
