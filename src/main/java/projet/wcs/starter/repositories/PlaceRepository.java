package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Place;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    public List<Place> findAll();
}
