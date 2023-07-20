package sage.springcoder.jamhubservice.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sage.springcoder.jamhubservice.web.controller.ItemNotFoundException;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.mappers.JamMapper;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;
import sage.springcoder.jamhubservice.web.repositories.JamRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class JamServiceImpl implements JamService {

    private final JamRepository jamRepository;
    private final JamMapper jamMapper;

    @Override
    public JamDto getJamById(UUID jamId) {
//        return JamDto.builder().jamId(jamId)
//                .jamName("Strawberry Blast")
//                .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
//                .build();
        return jamMapper.jamToJamDto(
                jamRepository.findById(jamId).orElseThrow(ItemNotFoundException::new)
        );
    }

    @Override
    public JamDto saveNewJam(JamDto jamDto) {
        return jamMapper.jamToJamDto(
                jamRepository.save(jamMapper.jamDtoToJam(jamDto))
        );
    }

    @Override
    public JamDto updateJam(UUID jamId, JamDto jamDto) {
        Jam jam = jamRepository.findById(jamId).orElseThrow(ItemNotFoundException::new);

        jam.setJamName(jamDto.getJamName());
        jam.setJamFlavor(jamDto.getJamFlavor());
        //and soo on..
        return jamMapper.jamToJamDto(jamRepository.save(jam));
    }
}
