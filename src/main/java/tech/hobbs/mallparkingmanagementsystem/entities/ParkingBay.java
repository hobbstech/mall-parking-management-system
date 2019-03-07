package tech.hobbs.mallparkingmanagementsystem.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;

@Entity
@Table(name = "parking_bays")
@Data
@EqualsAndHashCode(callSuper = true)
public class ParkingBay extends BaseEntity {

    @JoinColumn(referencedColumnName = "id", name = "section")
    @ManyToOne
    private Section section;

    @Column
    @Max(value = 50)
    private Long bayNumber;

    @Column
    private Boolean bayOccupied;

    @Column(unique = true)
    private String occupiedBy;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date occupiedAt;

    @Embedded
    private Coordinates coordinates;

    public ParkingBay() {
        this.bayOccupied = false;
    }
}
