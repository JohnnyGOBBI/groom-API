package projet.wcs.starter.controllers;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.entities.Booking;
import projet.wcs.starter.repositories.BookingRepository;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBooking(@PathVariable long id) {
        return bookingRepository.findById(id);
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
