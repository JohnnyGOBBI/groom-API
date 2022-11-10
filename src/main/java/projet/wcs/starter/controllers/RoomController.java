package projet.wcs.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping("/room")
    public String getRooms(){
        return "true";
    }

}
