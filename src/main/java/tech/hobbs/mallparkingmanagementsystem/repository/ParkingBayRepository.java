package tech.hobbs.mallparkingmanagementsystem.repository;

import tech.hobbs.mallparkingmanagementsystem.entities.ParkingBay;

import java.util.Optional;

public interface ParkingBayRepository extends BaseRepository<ParkingBay> {

    Optional<ParkingBay> findFirst1ByBayOccupiedIsFalse();

}
