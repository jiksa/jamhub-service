package sage.springcoder.jamhubservice.web.service;

import sage.springcoder.jamhubservice.web.model.JamDto;

import java.util.UUID;

public interface JamService {


    JamDto getJamById(UUID jamId);

    JamDto saveNewJam(JamDto jamDto);

    JamDto updateJam(UUID jamId, JamDto jamDto);
}
