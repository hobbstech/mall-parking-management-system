package tech.hobbs.mallparkingmanagementsystem.repository;

import tech.hobbs.mallparkingmanagementsystem.entities.Section;

import java.util.Optional;

public interface SectionRepository extends BaseRepository<Section> {

    Optional<Section> findByName(String name);

}
