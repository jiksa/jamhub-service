package sage.springcoder.jamhubservice.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    JamDto getDto(){
        return  JamDto.builder().jamName("Strwaberry Bliss")
                .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
                .upc(100677654L)
                .jamId(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("145.72"))
                .myLocalDate(LocalDate.now())
                .build();
    }
}
