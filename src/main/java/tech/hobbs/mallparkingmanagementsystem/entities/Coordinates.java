package tech.hobbs.mallparkingmanagementsystem.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Coordinates implements Serializable {

    private Double longitude;

    private Double latitude;

}
