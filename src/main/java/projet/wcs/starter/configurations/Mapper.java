package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dto.PlaceDto;
import projet.wcs.starter.dto.RoomDto;
import projet.wcs.starter.entities.Place;
import projet.wcs.starter.entities.Room;

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
        return modelMapper;
    }
}
