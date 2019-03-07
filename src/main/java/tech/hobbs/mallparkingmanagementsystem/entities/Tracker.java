package tech.hobbs.mallparkingmanagementsystem.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trackers")
@EqualsAndHashCode(callSuper = true)
@Data
public class Tracker extends BaseEntity {

    private String trackerCode;

    @Embedded
    private Coordinates coordinates;

}
