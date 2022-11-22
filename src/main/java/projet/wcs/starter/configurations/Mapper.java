package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dto.PlaceDto;
import projet.wcs.starter.entities.Place;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Place, PlaceDto> propertyMapper = modelMapper.createTypeMap(Place.class, PlaceDto.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getLocation().getId(), PlaceDto::setLocationId)
        );
        return modelMapper;
    }
}
