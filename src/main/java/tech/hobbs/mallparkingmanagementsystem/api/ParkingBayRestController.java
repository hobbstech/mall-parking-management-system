package tech.hobbs.mallparkingmanagementsystem.api;

import io.github.hobbstech.commonsutils.exceptions.InvalidRequestException;
import io.github.hobbstech.commonsutils.exceptions.RecordNotFoundException;
import org.springframework.web.bind.annotation.*;
import tech.hobbs.mallparkingmanagementsystem.entities.ParkingBay;
import tech.hobbs.mallparkingmanagementsystem.repository.ParkingBayRepository;
import tech.hobbs.mallparkingmanagementsystem.service.ParkingBayService;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.BayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateParkingBayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.OccupyingRequest;

import java.util.Collection;

@RestController
public class ParkingBayRestController {

    private final ParkingBayService parkingBayService;

    private final ParkingBayRepository parkingBayRepository;

    public ParkingBayRestController(ParkingBayService parkingBayService,
                                    ParkingBayRepository parkingBayRepository) {
        this.parkingBayService = parkingBayService;
        this.parkingBayRepository = parkingBayRepository;
    }

    @PostMapping("/v1/parking-bays")
    public ParkingBay createParkingBay(@RequestBody CreateParkingBayRequest createParkingBayRequest) {
        return parkingBayService.createParkingBay(createParkingBayRequest);
    }

    @PutMapping("/v1/parking-bays/{id}")
    public ParkingBay updateParkingBay(@PathVariable("id") Long id,
                                       @RequestBody CreateParkingBayRequest createParkingBayRequest) {
        return parkingBayService.updateParkingBay(id, createParkingBayRequest);
    }

    @GetMapping("/v1/parking-bays/{id}")
    public ParkingBay createParkingBay(@PathVariable("id") Long id) {
        return parkingBayRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Parking bay record was not found"));
    }

    @GetMapping("/v1/parking-bays")
    public Collection<ParkingBay> findAll() {
        return parkingBayRepository.findAll();
    }

    @PostMapping("/v1/parking-bays/occupy")
    public ParkingBay occupy(@RequestBody OccupyingRequest occupyingRequest) {
        return parkingBayService.occupy(occupyingRequest);
    }

    @PostMapping("/v1/parking-bays/vacant")
    public ParkingBay vacant(@RequestBody BayRequest bayRequest) {
        return parkingBayService.vacant(bayRequest);
    }

    @DeleteMapping("/v1/parking-bays/{id}")
    public void deleteBay(@PathVariable("id") Long id) {
        parkingBayRepository.deleteById(id);
    }

    @GetMapping("/v1/parking-bays/free")
    public ParkingBay freeBay() {
        return parkingBayRepository.findFirst1ByBayOccupiedIsFalse()
                .orElseThrow(() -> new InvalidRequestException("No free bay available"));
    }

}
