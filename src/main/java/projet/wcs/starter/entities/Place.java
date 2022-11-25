package projet.wcs.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String map;


    @OneToMany(mappedBy = "place")
    private List<Room> rooms;



    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] picture;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }




    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "location_id")
    private Location location;

    public Place(){

    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPicture() {
        return new String(picture, StandardCharsets.UTF_8);
    }

    public void setPicture(String picture) {
        this.picture = picture.getBytes();
    }

}
