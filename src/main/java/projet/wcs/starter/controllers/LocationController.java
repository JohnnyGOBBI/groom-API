package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Location;
import projet.wcs.starter.repositories.LocationRepository;
import projet.wcs.starter.services.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/locations")
public class LocationController {


    @Autowired
    private LocationRepository locationRepository;

    @GetMapping()
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable long id) {
        return locationRepository.findById(id);
    }

    @PostMapping()
    public Location create(@RequestBody @Valid Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    public Location update(@PathVariable int id, @RequestBody @Valid Location location) {
        location.setId(id);
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        locationRepository.deleteById(id);
        return "redirect:/locations";
    }


}
