package sage.springcoder.jamhubservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import sage.springcoder.jamhubservice.services.inventory.JamInventoryService;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamDto;

public abstract class JamMapperDecorator implements JamMapper{

    private JamInventoryService jamInventoryService;
    private JamMapper mapper;

    @Autowired
    public void setJamInventoryService(JamInventoryService jamInventoryService) {
        this.jamInventoryService = jamInventoryService;
    }

    @Autowired
    public void setMapper(JamMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JamDto jamToJamDto(Jam jam) {
        return mapper.jamToJamDto(jam);
    }

    @Override
    public JamDto jamToJamDtoWithInventory(Jam jam) {
        JamDto dto = mapper.jamToJamDto(jam);
        dto.setQuantityOnHand(jamInventoryService.getOnHandInventory(jam.getJamId()));
        System.out.println(dto.getQuantityOnHand());
        return dto;
    }

    @Override
    public Jam jamDtoToJam(JamDto jamDto) {
        return mapper.jamDtoToJam(jamDto);
    }

}
