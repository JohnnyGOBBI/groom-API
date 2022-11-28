package projet.wcs.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] picture;
    private int capacity;


//    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade = CascadeType.ALL)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "place_id")
    private Place place;



    public Room(){

    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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



    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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
