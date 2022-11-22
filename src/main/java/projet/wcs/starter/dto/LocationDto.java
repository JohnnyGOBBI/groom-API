package projet.wcs.starter.dto;

import java.util.List;

public class LocationDto {
    private int id;
    private String name;
    private String address;
    private String picture;
    private List<PlaceDto> places;

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
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceDto> places) {
        this.places = places;
    }
}
