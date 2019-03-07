package tech.hobbs.mallparkingmanagementsystem.service;

import tech.hobbs.mallparkingmanagementsystem.entities.Coordinates;
import tech.hobbs.mallparkingmanagementsystem.entities.Tracker;

public interface TrackerService {

    Tracker createTracker(CreateTrackerRequest createTrackerRequest);

    Tracker findTracker(String trackerId);

    Tracker updateTracker(Long id, CreateTrackerRequest createTrackerRequest);

    Tracker saveCoordinates(String trackerCode, Coordinates coordinates);
}
