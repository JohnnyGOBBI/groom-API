package projet.wcs.starter.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.wcs.starter.repositories.BookingRepository;
import projet.wcs.starter.repositories.RoomRepository;



@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;





}
