package projet.wcs.starter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.wcs.starter.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
