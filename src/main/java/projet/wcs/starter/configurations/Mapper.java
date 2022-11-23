package projet.wcs.starter.configurations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.dto.LocationDto;
import projet.wcs.starter.dto.PlaceDto;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Booking;
import projet.wcs.starter.entities.Location;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.entities.Room;


@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        TypeMap<Room, RoomDto> propertyMapperRoom = modelMapper.createTypeMap(Room.class, RoomDto.class);
        propertyMapperRoom.addMappings(
            mapper -> {
                mapper.map(src -> src.getPlace().getId(), RoomDto::setId);
            }
        );


        TypeMap<Booking, BookingDto> propertyMapperBooking = modelMapper.createTypeMap(Booking.class, BookingDto.class);
        propertyMapperBooking.addMappings(
                mapper -> {
                    mapper.map(src -> src.getRoom().getId(),BookingDto::setId);
                    mapper.map(src -> src.getBeginDate(),BookingDto::setBeginDate);
                    mapper.map(src -> src.getEndDate(),BookingDto::setEndDate);
                    mapper.map(src -> src.getEmail(),BookingDto::setEmail);
                }
        );

        TypeMap<Place, PlaceDto> propertyMapperPlace = modelMapper.createTypeMap(Place.class, PlaceDto.class);
        propertyMapperPlace.addMappings(
                mapper -> {
                    mapper.map(src -> src.getLocation().getId(),PlaceDto::setId);
                    mapper.map(src -> src.getName(),PlaceDto::setName);
                    mapper.map(src -> src.getMap(),PlaceDto::setMap);
                }
        );

        TypeMap<Location, LocationDto> propertyMapperLocation = modelMapper.createTypeMap(Location.class, LocationDto.class);
        propertyMapperLocation.addMappings(
                mapper -> {
                    mapper.map(src -> src.getName(),LocationDto::setName);
                    mapper.map(src -> src.getAddress(),LocationDto::setAddress);
                    mapper.map(src -> src.getPicture(),LocationDto::setPicture);
                }

        );

        return modelMapper;
    }

}
