package tech.hobbs.mallparkingmanagementsystem.service;

import tech.hobbs.mallparkingmanagementsystem.entities.ParkingBay;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.BayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateParkingBayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.OccupyingRequest;

public interface ParkingBayService {

    ParkingBay createParkingBay(CreateParkingBayRequest createParkingBayRequest);

    ParkingBay updateParkingBay(Long id, CreateParkingBayRequest createParkingBayRequest);

    ParkingBay occupy(OccupyingRequest occupyingRequest);

    ParkingBay vacant(BayRequest bayRequest);
}
