package tech.hobbs.mallparkingmanagementsystem.service;

import io.github.hobbstech.commonsutils.exceptions.RecordNotFoundException;
import lombok.val;
import org.springframework.stereotype.Service;
import tech.hobbs.mallparkingmanagementsystem.entities.ParkingBay;
import tech.hobbs.mallparkingmanagementsystem.entities.Section;
import tech.hobbs.mallparkingmanagementsystem.repository.ParkingBayRepository;
import tech.hobbs.mallparkingmanagementsystem.repository.SectionRepository;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.BayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateParkingBayRequest;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.OccupyingRequest;

import java.util.Date;

@Service
public class ParkingBayServiceImpl implements ParkingBayService {

    private final ParkingBayRepository parkingBayRepository;

    private final SectionRepository sectionRepository;

    public ParkingBayServiceImpl(ParkingBayRepository parkingBayRepository, SectionRepository sectionRepository) {
        this.parkingBayRepository = parkingBayRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public ParkingBay createParkingBay(CreateParkingBayRequest createParkingBayRequest) {
        val parkingBay = new ParkingBay();
        parkingBay.setBayNumber((createParkingBayRequest.getBayNumber().longValue()));
        val section = findSection(createParkingBayRequest.getSectionId());
        parkingBay.setSection(section);

        return parkingBayRepository.save(parkingBay);
    }

    private Section findSection(Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(()->new RecordNotFoundException("Section Record was not found"));
    }

    private ParkingBay findParkingBay(Long parkingBayId){
        return parkingBayRepository.findById(parkingBayId)
                .orElseThrow(()->new RecordNotFoundException("Parking bay was not found"));
    }

    @Override
    public ParkingBay updateParkingBay(Long id, CreateParkingBayRequest createParkingBayRequest) {
        val parkingBay = findParkingBay(id);
        val section = findSection(createParkingBayRequest.getSectionId());
        parkingBay.setBayNumber(createParkingBayRequest.getBayNumber().longValue());
        parkingBay.setSection(section);
        return parkingBayRepository.save(parkingBay);
    }

    @Override
    public ParkingBay occupy(OccupyingRequest occupyingRequest) {
        val parkingBay = findParkingBay(occupyingRequest.getParkingBayId());
        parkingBay.setCoordinates(occupyingRequest.getCoordinates());
        parkingBay.setBayOccupied(true);
        parkingBay.setOccupiedAt(new Date());
        parkingBay.setOccupiedBy(occupyingRequest.getOccupiedBy());

        return parkingBayRepository.save(parkingBay);
    }

    @Override
    public ParkingBay vacant(BayRequest bayRequest) {
        val parkingBay = findParkingBay(bayRequest.getParkingBayId());
        parkingBay.setOccupiedBy("none");
        parkingBay.setOccupiedAt(null);
        parkingBay.setBayOccupied(false);
        return parkingBayRepository.save(parkingBay);
    }
}
