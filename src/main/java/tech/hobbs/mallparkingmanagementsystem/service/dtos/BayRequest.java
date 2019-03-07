package tech.hobbs.mallparkingmanagementsystem.service.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class BayRequest {


    @NotNull(message = "Parking bay id should be provided")
    @Min(value = 1, message = "Invalid parking bay id provided")
    private Long parkingBayId;

}
