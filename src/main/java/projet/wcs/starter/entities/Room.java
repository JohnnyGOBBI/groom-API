package projet.wcs.starter.entities;

import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.util.List;
import java.util.Locale;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String picture;
    private int capacity;

    public Room(){

    }

    @ManyToOne(fetch=FetchType.EAGER, optional=true, cascade = CascadeType.ALL)
    private Place place;


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }



}
