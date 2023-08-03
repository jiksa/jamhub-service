package sage.springcoder.jamhubservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamDto;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(JamMapperDecorator.class)
public interface JamMapper {

    JamDto jamToJamDto(Jam jam);

    JamDto jamToJamDtoWithInventory(Jam jam);

    Jam jamDtoToJam(JamDto jamDto);
}
