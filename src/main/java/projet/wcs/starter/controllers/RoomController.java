package projet.wcs.starter.controllers;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Booking;
import projet.wcs.starter.entities.Room;
import projet.wcs.starter.repositories.BookingRepository;
import projet.wcs.starter.repositories.LocationRepository;
import projet.wcs.starter.repositories.RoomRepository;
import projet.wcs.starter.services.RoomService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/rooms/all")
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll().stream().map(
                rooms -> modelMapper.map(rooms, RoomDto.class)
        ).collect(Collectors.toList());
    }

    @GetMapping("/rooms/{id}")
    public RoomDto getRoom(@PathVariable long id) {
        return modelMapper.map(roomRepository.findById(id).get(),RoomDto.class);
    }

    @PostMapping("/rooms")
    public RoomDto create(@RequestBody RoomDto roomDto) {
        Room savedRoom = roomRepository.save(modelMapper.map(roomDto, Room.class));
        return modelMapper.map(savedRoom, RoomDto.class);
    }

    @PutMapping("/rooms/{id}")
    public RoomDto update(@PathVariable int id, @RequestBody @Valid RoomDto roomDto) {
        roomDto.setId(id);
        Room room = roomRepository.save(modelMapper.map(roomDto, Room.class));
        return modelMapper.map(room, RoomDto.class);
    }

    @DeleteMapping("/rooms/{id}")
    public void delete(@PathVariable Long id) {
       roomRepository.deleteById(id);
    }

    @RequestMapping("/places/{id}/rooms")
    public List<Room> getRoomsByplaceId(@PathVariable int id) {
        return roomRepository.findByPlaceId(id);
    }

    @RequestMapping("/room/{id}/place")
    public List<Room> getRoomsByPlaceAndCapacity(@RequestParam long placeId, @RequestParam int capacity){
        return roomRepository.findByPlaceIdAndCapacity(placeId,capacity);
    }

    @RequestMapping("/room/placeandcapcity")
    public List<Room> getRoomsByPlaceNameAndCapacity(@RequestParam int capacity) {
        return roomRepository.findByCapacity(capacity);
    }

    }


    @RequestMapping("/rooms/bookings")

    public List<Room> getRoomsByPlaceAndCapacity(@RequestParam  int placeId,@RequestParam int capacity,@RequestParam String beginString,@RequestParam String  endString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date beginDate = simpleDateFormat.parse(beginString);
        Date endDate = simpleDateFormat.parse(endString);
        List<Room> rooms = roomRepository.findByPlaceIdAndCapacity(placeId, capacity);
        return rooms.stream().filter(room -> {
            List<Booking> bookings = bookingRepository.findByRoomId(room.getId());
            bookings = bookings.stream().filter(booking -> {
                boolean beginDateIsInSearch = booking.getBeginDate().compareTo(beginDate) > 0 && booking.getBeginDate().compareTo(endDate) < 0;
                boolean endDateIsInSearch = booking.getEndDate().compareTo(beginDate) > 0 && booking.getEndDate().compareTo(endDate) < 0;
                boolean searchIsInBooking = booking.getBeginDate().compareTo(beginDate) < 0 && booking.getEndDate().compareTo(endDate) > 0;

                if (beginDateIsInSearch || endDateIsInSearch || searchIsInBooking) {
                    return false;
                }
                return true;
            }).toList();
            if (bookings.size() > 0) {
                return false;
            }
            return true;
        }).toList();

    }





}
