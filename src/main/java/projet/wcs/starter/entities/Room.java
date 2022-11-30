package projet.wcs.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jshell.Snippet;

import java.util.List;
import java.util.Locale;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull

    private String name;
    @NotNull
    private String picture;
    @NotNull
    private int capacity;


    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
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
