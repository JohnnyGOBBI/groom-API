package projet.wcs.starter.dto;

public class RoomPlaceDto {
    private long roomId;
    private String name;
    private String picture;
    private  int capacity;
    private long PlaceId;

    private String map;
    private String placeName;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(long placeId) {
        PlaceId = placeId;
    }


}
