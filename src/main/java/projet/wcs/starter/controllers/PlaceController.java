package projet.wcs.starter.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class PlaceController {
    @GetMapping("/room")
    public String getPlaces(){
        return "true";
    }
}
