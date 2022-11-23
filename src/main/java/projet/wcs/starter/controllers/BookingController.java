package projet.wcs.starter.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import projet.wcs.starter.repositories.BookingRepository;



@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;





}
