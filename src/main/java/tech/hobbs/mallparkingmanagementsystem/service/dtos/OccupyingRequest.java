package tech.hobbs.mallparkingmanagementsystem.service.dtos;

import lombok.Data;
import tech.hobbs.mallparkingmanagementsystem.entities.Coordinates;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OccupyingRequest extends BayRequest{

    @NotBlank(message = "Bay occupier should be provided")
    private String occupiedBy;

    @NotNull(message = "Coordinate should be provided")
    private Coordinates coordinates;

}
