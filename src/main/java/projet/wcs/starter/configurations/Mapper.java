package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dto.PlaceDto;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.dto.BookingDto;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.entities.Room;
import projet.wcs.starter.entities.Booking;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Place, PlaceDto> placeMapper = modelMapper.createTypeMap(Place.class, PlaceDto.class);
        placeMapper.addMappings(
                mapper -> mapper.map(src -> src.getLocation().getId(), PlaceDto::setLocationId)
        );

        TypeMap<Room, RoomDto> roomMapper = modelMapper.createTypeMap(Room.class, RoomDto.class);
        roomMapper.addMappings(
                mapper -> mapper.map(src -> src.getPlace().getId(), RoomDto::setPlaceId)
        );
        
        TypeMap<Booking, BookingDto> propertyMapperBooking = modelMapper.createTypeMap(Booking.class, BookingDto.class);
        propertyMapperBooking.addMappings(
                mapper -> {
                    mapper.map(src -> src.getRoom().getId(),BookingDto::setRoomId);
                    mapper.map(src -> src.getBeginDate(),BookingDto::setBeginDate);
                    mapper.map(src -> src.getEndDate(),BookingDto::setEndDate);
                    mapper.map(src -> src.getEmail(),BookingDto::setEmail);
                    mapper.map(src -> src.getBookingNumber(),BookingDto::setBookingNumber);
                }
        );
        
        return modelMapper;
    }

}
