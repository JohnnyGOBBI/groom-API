package projet.wcs.starter.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Room;
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
    private ModelMapper modelMapper;


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
    public RoomDto create(@RequestBody RoomDto roomDto) {
        Room room = modelMapper.map(roomDto, Room.class);
        Room savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomDto.class);
    }

    @PutMapping("/rooms/{id}")
    public RoomDto update(@PathVariable int id, @RequestBody @Valid RoomDto roomDto) {
        roomDto.setId(id);
        Room room = roomRepository.save(modelMapper.map(roomDto, Room.class));
        return modelMapper.map(room, RoomDto.class);
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


