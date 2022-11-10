package projet.wcs.starter.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String map;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = true)
    private List<Location> locations;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
    @JoinColumn(name = "room_idRoom", nullable = true)
    public Room room;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
