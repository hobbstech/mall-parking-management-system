package tech.hobbs.mallparkingmanagementsystem.api;

import io.github.hobbstech.commonsutils.exceptions.RecordNotFoundException;
import org.springframework.web.bind.annotation.*;
import tech.hobbs.mallparkingmanagementsystem.entities.Section;
import tech.hobbs.mallparkingmanagementsystem.repository.SectionRepository;
import tech.hobbs.mallparkingmanagementsystem.service.dtos.CreateSectionRequest;
import tech.hobbs.mallparkingmanagementsystem.service.SectionService;

import java.util.Collection;

@RestController
public class SectionRestController {

    private final SectionService sectionService;

    private final SectionRepository sectionRepository;

    public SectionRestController(SectionService sectionService, SectionRepository sectionRepository) {
        this.sectionService = sectionService;
        this.sectionRepository = sectionRepository;
    }

    @PostMapping("/v1/sections")
    public Section createSection(@RequestBody CreateSectionRequest createSectionRequest){
        return sectionService.createSection(createSectionRequest);
    }

    @PutMapping("/v1/sections/{id}")
    public Section updateSection(@RequestBody CreateSectionRequest createSectionRequest,
                                 @PathVariable("id") Long id){
        return sectionService.updateSection(id, createSectionRequest);
    }

    @GetMapping("/v1/sections")
    public Collection<Section> findAll(){
        return sectionRepository.findAll();
    }

    @GetMapping("/v1/sections/{id}")
    public Section findOne(@PathVariable("id") Long id){
        return sectionRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Section record was not found"));
    }

    @DeleteMapping("/v1/sections/{id}")
    public void deleteSections(@PathVariable("id") Long id){
        sectionRepository.deleteById(id);
    }

}
