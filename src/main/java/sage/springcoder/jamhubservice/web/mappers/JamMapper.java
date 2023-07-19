package sage.springcoder.jamhubservice.web.mappers;

import org.mapstruct.Mapper;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamDto;

@Mapper(uses = {DateMapper.class})
public interface JamMapper {

    JamDto jamToJamDto(Jam jam);

    Jam jamDtoToJam(JamDto jamDto);
}
