package sage.springcoder.jamhubservice.services.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sage.springcoder.jamhubservice.services.inventory.model.JamInventoryDto;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Slf4j
@ConfigurationProperties(prefix = "jix.jamhub",ignoreUnknownFields = false)
@Component
public class JamInventoryServiceRestTemplateImpl implements JamInventoryService{

    private String jamhubInventoryServiceHost;

    private final String INVENTORY_PATH = "/api/v1/jam/{jamId}/inventory";
    private final RestTemplate restTemplate;
    @Autowired
    public JamInventoryServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setJamhubInventoryServiceHost(String jamhubInventoryServiceHost) {
        this.jamhubInventoryServiceHost = jamhubInventoryServiceHost;
    }

    @Override
    public Integer getOnHandInventory(UUID jamId) {
        log.info("Calling inventory service ..");

        ResponseEntity<List<JamInventoryDto>> responseEntity = restTemplate
                .exchange(jamhubInventoryServiceHost + INVENTORY_PATH, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<JamInventoryDto>>() {},
                        (Object)jamId);

        //Sum from inverntory list
        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream()
                .mapToInt(JamInventoryDto::getQuantityOnHand)
                .sum();
        return onHand;
    }
}
