package tech.hobbs.mallparkingmanagementsystem.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
@Data
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity {

    @Column(length = 2, unique = true)
    private String name;

}
