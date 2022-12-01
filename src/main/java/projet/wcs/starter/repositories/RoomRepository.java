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

    public List<Room> findAll();
    public List<Room> findByPlaceId(int placeId);

    public List<Room> findByCapacity(int capacity);

    public List<Room> findByPlaceIdAndCapacity(long placeId, int capacity);
    
    public List<Room> findByPlaceIdAndCapacityAfter(long placeId, int capacity);






}

