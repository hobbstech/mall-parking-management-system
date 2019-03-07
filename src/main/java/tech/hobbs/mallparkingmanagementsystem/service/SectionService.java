package tech.hobbs.mallparkingmanagementsystem.service;

import tech.hobbs.mallparkingmanagementsystem.entities.Section;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateSectionRequest;

public interface SectionService {

    Section createSection(CreateSectionRequest createSectionRequest);

    Section updateSection(Long id, CreateSectionRequest createSectionRequest);

}
