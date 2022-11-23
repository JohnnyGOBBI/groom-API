package projet.wcs.starter.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.repositories.PlaceRepository;

import java.util.List;

@RestController
@CrossOrigin
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/places")
    public List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }






}