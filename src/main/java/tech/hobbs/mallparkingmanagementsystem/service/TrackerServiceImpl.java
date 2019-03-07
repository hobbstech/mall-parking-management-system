package tech.hobbs.mallparkingmanagementsystem.service;

import lombok.val;
import org.springframework.stereotype.Service;
import tech.hobbs.mallparkingmanagementsystem.entities.Coordinates;
import tech.hobbs.mallparkingmanagementsystem.entities.Tracker;
import tech.hobbs.mallparkingmanagementsystem.repository.TrackerRepository;
import tech.hobbs.mallparkingmanagementsystem.utils.exceptions.InvalidRequestException;
import tech.hobbs.mallparkingmanagementsystem.utils.exceptions.RecordNotFoundException;

import static tech.hobbs.mallparkingmanagementsystem.utils.exceptions.ExceptionUtils.requireNonNull;

@Service
public class TrackerServiceImpl implements TrackerService {

    private final TrackerRepository trackerRepository;

    public TrackerServiceImpl(TrackerRepository trackerRepository) {
        this.trackerRepository = trackerRepository;
    }

    @Override
    public Tracker createTracker(CreateTrackerRequest createTrackerRequest) {

        trackerRepository.findByTrackerCode(createTrackerRequest.getTrackerCode())
                .ifPresent(tracker -> {
                    throw new InvalidRequestException("Tracker with the given code already exist");
                });

        val tracker = new Tracker();
        tracker.setTrackerCode(createTrackerRequest.getTrackerCode());

        return trackerRepository.save(tracker);
    }

    @Override
    public Tracker findTracker(String trackerCode) {
        return trackerRepository.findByTrackerCode(trackerCode)
                .orElseThrow(() -> new RecordNotFoundException("Tracker not found"));
    }

    @Override
    public Tracker updateTracker(Long id, CreateTrackerRequest createTrackerRequest) {

        val tracker = trackerRepository
                .findById(id).orElseThrow(() -> new RecordNotFoundException("Tracker was not found"));

        trackerRepository.findByTrackerCode(createTrackerRequest.getTrackerCode())
                .filter(tracker1 -> !tracker1.getId().equals(id))
                .ifPresent(tracker1 -> {
                    throw new InvalidRequestException("Tracker code already in use");
                });

        tracker.setTrackerCode(createTrackerRequest.getTrackerCode());


        return trackerRepository.save(tracker);
    }

    @Override
    public Tracker saveCoordinates(String trackerCode, Coordinates coordinates) {
        val tracker = findTracker(trackerCode);
        requireNonNull(coordinates, () -> new InvalidRequestException("Coordinates should be provided"));
        requireNonNull(coordinates.getLatitude(), () -> new InvalidRequestException("Latitude should be provided"));
        requireNonNull(coordinates.getLongitude(), () -> new InvalidRequestException("Longitude should be provided"));
        tracker.setCoordinates(coordinates);
        return trackerRepository.save(tracker);
    }
}
