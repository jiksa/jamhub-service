package sage.springcoder.jamhubservice.web.service;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sage.springcoder.jamhubservice.web.controller.ItemNotFoundException;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.mappers.JamMapper;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamPagedList;
import sage.springcoder.jamhubservice.web.repositories.JamRepository;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JamServiceImpl implements JamService {

    private final JamRepository jamRepository;
    private final JamMapper jamMapper;
    @Cacheable(cacheNames = "jamCache", key = "#jamId", condition = "#showInventoryOnHand == false")
    @Override
    public JamDto getJamById(UUID jamId, Boolean showInventoryOnHand) {
//        return JamDto.builder().jamId(jamId)
//                .jamName("Strawberry Blast")
//                .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
//                .build();
        if(showInventoryOnHand) {
            return jamMapper.jamToJamDtoWithInventory(
                    jamRepository.findById(jamId).orElseThrow(ItemNotFoundException::new)
            );
        }else {
            return jamMapper.jamToJamDto(
                    jamRepository.findById(jamId).orElseThrow(ItemNotFoundException::new)
            );
        }
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
    @Cacheable(cacheNames = "jamListCache", condition = "#showInventoryOnHand == false ")
    @Override
    public JamPagedList listJams(String jamName, String jamFlavor, PageRequest pageRequest, Boolean showInventoryOnHand) {
       // System.out.println("Called listJams method - Cache test");

            JamPagedList jamPagedList;
            Page<Jam> jamPage;

            if (!StringUtils.isEmpty(jamName) && !StringUtils.isEmpty(jamFlavor)) {
                //search both
                jamPage = jamRepository.findAllByJamNameAndJamFlavor(jamName, jamFlavor, pageRequest);
            } else if (!StringUtils.isEmpty(jamName) && StringUtils.isEmpty(jamFlavor)) {
                //search jam_service name
                jamPage = jamRepository.findAllByJamName(jamName, pageRequest);
            } else if (StringUtils.isEmpty(jamName) && !StringUtils.isEmpty(jamFlavor)) {
                //search jam_service flavor
                jamPage = jamRepository.findAllByJamFlavor(jamFlavor, pageRequest);
            } else {
                jamPage = jamRepository.findAll(pageRequest);
            }

            if (showInventoryOnHand){
                jamPagedList = new JamPagedList(jamPage
                        .getContent()
                        .stream()
                        .map(jamMapper::jamToJamDtoWithInventory)
                        .collect(Collectors.toList()),
                        PageRequest
                                .of(jamPage.getPageable().getPageNumber(),
                                        jamPage.getPageable().getPageSize()),
                        jamPage.getTotalElements());
            } else {
                jamPagedList = new JamPagedList(jamPage
                        .getContent()
                        .stream()
                        .map(jamMapper::jamToJamDto)
                        .collect(Collectors.toList()),
                        PageRequest
                                .of(jamPage.getPageable().getPageNumber(),
                                        jamPage.getPageable().getPageSize()),
                        jamPage.getTotalElements());
            }

            return jamPagedList;

        }
}
