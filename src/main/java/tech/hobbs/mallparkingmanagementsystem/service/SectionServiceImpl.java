package tech.hobbs.mallparkingmanagementsystem.service;

import io.github.hobbstech.commonsutils.exceptions.InvalidRequestException;
import io.github.hobbstech.commonsutils.exceptions.RecordNotFoundException;
import lombok.val;
import org.springframework.stereotype.Service;
import tech.hobbs.mallparkingmanagementsystem.entities.Section;
import tech.hobbs.mallparkingmanagementsystem.repository.SectionRepository;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateSectionRequest;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section createSection(CreateSectionRequest createSectionRequest) {
        val section = new Section();
        section.setName(createSectionRequest.getName());
        return sectionRepository.save(section);
    }

    @Override
    public Section updateSection(Long id, CreateSectionRequest createSectionRequest) {
        sectionRepository.findByName(createSectionRequest.getName())
                .ifPresent(section -> {
                    throw new InvalidRequestException("Section with same name already exist");
                });
        val section = sectionRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Section was not found"));
        section.setName(createSectionRequest.getName());
        return sectionRepository.save(section);
    }
}
