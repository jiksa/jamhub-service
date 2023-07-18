package sage.springcoder.jamhubservice.web.service;

import org.springframework.stereotype.Service;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;

import java.util.UUID;

@Service
public class JamServiceImpl implements JamService{
    @Override
    public JamDto getJamById(UUID jamId) {
        return JamDto.builder().jamId(jamId)
                .jamName("Strawberry Blast")
                .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
                .build();
    }
}
