package projet.wcs.starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.entities.Room;
import projet.wcs.starter.repositories.LocationRepository;
import projet.wcs.starter.repositories.RoomRepository;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private LocationRepository locationRepository;


    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoom(@PathVariable long id) {
        return roomRepository.findById(id);
    }


    @RequestMapping("/places/{id}/rooms")
    public List<Room> getRoomsByplaceId(@PathVariable long id) {

        return roomRepository.findByPlaceId(id);

    }

    @RequestMapping("/locations/{id}/rooms")
    public List<Room> getRoomsByLocationId(@PathVariable long id){
        return roomRepository.findByLocationId(id);
    }

    @RequestMapping("/roomList")
    public List<Room> getRoomsByPlaceAndCapacity(@RequestParam long placeId,@RequestParam int capacity){
        return roomRepository.findByPlaceIdAndCapacity(placeId,capacity);
    }

    @RequestMapping("/room/placeandcapcity")
    public List<Room> getRoomsByPlaceNameAndCapacity(@RequestParam int capacity){
        return roomRepository.findByCapacity(capacity);
    }























}


