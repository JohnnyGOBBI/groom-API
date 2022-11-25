package projet.wcs.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.util.List;
import java.util.Locale;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String picture;
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





}
