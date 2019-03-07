package tech.hobbs.mallparkingmanagementsystem.api;

import org.springframework.web.bind.annotation.*;
import tech.hobbs.mallparkingmanagementsystem.entities.Coordinates;
import tech.hobbs.mallparkingmanagementsystem.entities.Tracker;
import tech.hobbs.mallparkingmanagementsystem.repository.TrackerRepository;
import tech.hobbs.mallparkingmanagementsystem.service.CreateTrackerRequest;
import tech.hobbs.mallparkingmanagementsystem.service.TrackerService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class TrackerRestController {

    private final TrackerService trackerService;

    private final TrackerRepository trackerRepository;

    public TrackerRestController(TrackerService trackerService,
                                 TrackerRepository trackerRepository) {
        this.trackerService = trackerService;
        this.trackerRepository = trackerRepository;
    }

    @PostMapping("/v1/trackers")
    public Tracker createTracker(@Valid @RequestBody CreateTrackerRequest createTrackerRequest){
        return trackerService.createTracker(createTrackerRequest);
    }

    @GetMapping("/v1/trackers")
    public Collection<Tracker> findAll(){
        return trackerRepository.findAll();
    }

    @GetMapping("/v1/trackers/with-code")
    public Tracker findTracker(@RequestParam("trackerCode") String trackerId){
        return trackerService.findTracker(trackerId);
    }

    @PutMapping("/v1/trackers/{id}")
    public Tracker updateTracker(@PathVariable("id") Long id ,@Valid @RequestBody CreateTrackerRequest createTrackerRequest){
        return trackerService.updateTracker(id, createTrackerRequest);
    }

    @DeleteMapping("/v1/trackers/{id}")
    public void deleteTracker(@PathVariable("id") Long id ,@Valid @RequestBody CreateTrackerRequest createTrackerRequest){
        trackerRepository.deleteById(id);
    }

    @PutMapping("/v1/trackers/save-coordinates")
    public Tracker saveCoordinates(@RequestParam("trackerCode") String trackerCode,
                                   @RequestBody Coordinates coordinates){

        return trackerService.saveCoordinates(trackerCode, coordinates);

    }

}
