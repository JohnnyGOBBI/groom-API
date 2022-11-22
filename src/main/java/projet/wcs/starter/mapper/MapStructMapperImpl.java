//package projet.wcs.starter.mapper;
//
//
//import org.springframework.stereotype.Component;
//import projet.wcs.starter.dto.LocationDto;
//import projet.wcs.starter.dto.PlaceDto;
//import projet.wcs.starter.entities.Location;
//import projet.wcs.starter.entities.Place;
//
//import java.util.List;
//
//@Component
//public class MapStructMapperImpl implements MapStructMapper {
//
//    @Override
//    public LocationDto locationToLocationDto(Location location) {
//        if(location == null) {
//            return null;
//        }
//
//        LocationDto locationDto = new LocationDto();
//
//        locationDto.setId(location.getId());
//        locationDto.setName(location.getName());
//        locationDto.setAddress(location.getAddress());
//        locationDto.setPicture(location.getPicture());
//
//        return locationDto;
//    }
//
//    @Override
//    public PlaceDto placeToPlaceDto(Place place) {
//        if(place == null) {
//            return null;
//        }
//
//        PlaceDto placeDto = new PlaceDto();
//
//        placeDto.setId(place.getId());
//        placeDto.setName(place.getName());
//        placeDto.setMap(place.getMap());
//    }
//
//    @Override
//    public List<PlaceDto> placeToPlaceDto(List<Place> pLaces) {
//        return null;
//    }
//}
