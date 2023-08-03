package sage.springcoder.jamhubservice.web.service;

import org.springframework.data.domain.PageRequest;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;
import sage.springcoder.jamhubservice.web.model.JamPagedList;

import java.util.UUID;

public interface JamService {


    JamDto getJamById(UUID jamId);

    JamDto saveNewJam(JamDto jamDto);

    JamDto updateJam(UUID jamId, JamDto jamDto);

    JamPagedList listJams(String jamName, String jamFlavor, PageRequest pageRequest, Boolean showInventoryOnHand);
}
