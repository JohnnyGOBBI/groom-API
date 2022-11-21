package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.repositories.PlaceRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    private List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Place> getPlace(@PathVariable long id) {
        return placeRepository.findById(id);
    }

    @PostMapping()
    public Place create(@RequestBody @Valid Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable int id, @RequestBody @Valid Place place) {
        place.setId(id);
        return placeRepository.save(place);
    }



}