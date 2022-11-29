package projet.wcs.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] picture;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<Place> places;





    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Location(){

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPicture() {
        if(picture == null) {
            return null;
        }
        return new String(picture, StandardCharsets.UTF_8);
    }

    public void setPicture(String picture) {
        if(picture != null)
            this.picture = picture.getBytes();
    }
}
