package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
