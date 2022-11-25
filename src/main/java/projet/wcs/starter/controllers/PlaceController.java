package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dto.PlaceDto;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.repositories.PlaceRepository;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

@RequestMapping("/places")

public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    private List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Place> getPlace(@PathVariable long id) {
        return placeRepository.findById(id);
    }

    @PostMapping()
    public PlaceDto create(@RequestBody @Valid PlaceDto placeDto) {
        Place savedPlace = placeRepository.save(modelMapper.map(placeDto, Place.class));
        return modelMapper.map(savedPlace, PlaceDto.class);
    }

    @PutMapping("/{id}")
    public PlaceDto update(@PathVariable int id, @RequestBody @Valid PlaceDto placeDto) {
        placeDto.setId(id);
        Place place = placeRepository.save(modelMapper.map(placeDto, Place.class));
        return modelMapper.map(place, PlaceDto.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        placeRepository.deleteById(id);
    }


    @RequestMapping("/places/{id}")
    public Optional<Place> getPlaces(@PathVariable long id){
        return placeRepository.findById(id);
    }



}