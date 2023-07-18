package sage.springcoder.jamhubservice.web.service;

import org.springframework.http.ResponseEntity;
import sage.springcoder.jamhubservice.web.model.JamDto;

import java.util.UUID;

public interface JamService {


    JamDto getJamById(UUID jamId);
}
