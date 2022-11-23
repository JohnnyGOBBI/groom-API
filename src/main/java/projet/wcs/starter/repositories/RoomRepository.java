package projet.wcs.starter.repositories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Room;
import java.util.List;



@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room,Long> {
    public List<Room> findByPlaceId(long placeId);
    List<RoomDto> findByPlaceIdAndCapacityAfter(int placeId, int capacity);







}

