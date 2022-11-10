package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
