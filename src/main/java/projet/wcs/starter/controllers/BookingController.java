package projet.wcs.starter.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.entities.Booking;
import projet.wcs.starter.repositories.BookingRepository;
import projet.wcs.starter.repositories.RoomRepository;
import projet.wcs.starter.services.RoomService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@CrossOrigin
@RequestMapping("/bookings")
@Transactional

public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    private RoomRepository roomRepository;


  @PostMapping("/bookings")
      public BookingDto postBooking(@RequestBody @Valid BookingDto bookingDto) {
      bookingDto.setBookingNumber(RoomService.generateRandomNumber());
      Booking bookings = modelMapper.map(bookingDto, Booking.class);
      bookings = bookingRepository.save(bookings);
      bookingDto = modelMapper.map(bookings, BookingDto.class);
      return bookingDto;

  }
    @GetMapping()
    public BookingDto getBookings(@RequestParam String beginDate,@RequestParam String  endDate,@RequestParam String  roomId,@RequestParam String bookingNumber) {
        return modelMapper.map(bookingRepository.findAll().getClass(),BookingDto.class);
    }


    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable long id) {
        return modelMapper.map(bookingRepository.findById(id).get(),BookingDto.class);
    }
    
        @PutMapping("/{id}")
    public BookingDto update(@PathVariable int id, @RequestBody @Valid BookingDto bookingDto) {
        bookingDto.setId(id);
        Booking booking = bookingRepository.save(modelMapper.map(bookingDto, Booking.class));
        return modelMapper.map(booking, BookingDto.class);
    }
    
        @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }

}





