package projet.wcs.starter.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Place;


@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place,Long> {

}
