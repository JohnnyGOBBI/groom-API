package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
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


    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public Optional<Room> getRoom(@PathVariable long id) {
        return roomRepository.findById(id);
    }

    @PostMapping("/rooms")
    public Room create(@RequestBody @Valid Room room) {
        return roomRepository.save(room);
    }


    @RequestMapping("/places/{id}/rooms")
    public List<Room> getRoomsByplaceId(@PathVariable int id) {

        return roomRepository.findByPlaceId(id);

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


