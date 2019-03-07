package tech.hobbs.mallparkingmanagementsystem.repository;

import tech.hobbs.mallparkingmanagementsystem.entities.Tracker;

import java.util.Optional;

public interface TrackerRepository extends BaseRepository<Tracker> {

    Optional<Tracker> findByTrackerCode(String trackerCode);

}
