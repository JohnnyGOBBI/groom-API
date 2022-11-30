package projet.wcs.starter.repositories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Booking;

import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByRoomId(long id);


}

