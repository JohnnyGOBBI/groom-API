package projet.wcs.starter.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.entities.Booking;
import projet.wcs.starter.repositories.BookingRepository;
import projet.wcs.starter.repositories.RoomRepository;
import projet.wcs.starter.services.RoomService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookings")
@Transactional

public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    private RoomRepository roomRepository;


  @PostMapping()
      public BookingDto postBooking(@RequestBody @Valid BookingDto bookingDto) {
      bookingDto.setBookingNumber(RoomService.generateRandomNumber());
      Booking bookings = modelMapper.map(bookingDto, Booking.class);
      bookings = bookingRepository.save(bookings);
      bookingDto = modelMapper.map(bookings, BookingDto.class);
      return bookingDto;

  }
    @GetMapping()
    public List<Booking> getBookings(@RequestParam(required = false) String number) {
      return bookingRepository.findAll();
    }


    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable long id) {
      return modelMapper.map(bookingRepository.findById(id), BookingDto.class);
    }

    @GetMapping("/byNumber")
    public BookingDto getBooking(@RequestParam String number, @RequestParam(required = false) String password) {
        BookingDto bookingDto = modelMapper.map(bookingRepository.findByBookingNumber(number).get(), BookingDto.class);
        if (bookingDto.getPassword() != null && !bookingDto.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return bookingDto;
    }
    
    @PutMapping("/{id}")
    public BookingDto update(@PathVariable int id, @RequestBody @Valid BookingDto bookingDto) {
        bookingDto.setId(id);
        Booking booking = bookingRepository.save(modelMapper.map(bookingDto, Booking.class));
        return modelMapper.map(booking, BookingDto.class);
    }
    
        @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      try{
          bookingRepository.deleteById(id);
      } catch (Exception e) {
          System.out.println(e);
      }
    }

}





