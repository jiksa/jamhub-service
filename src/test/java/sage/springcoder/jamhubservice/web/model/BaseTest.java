package sage.springcoder.jamhubservice.web.model;

import sage.springcoder.jamhubservice.web.bootstrap.JamLoader;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

    JamDto getDto(){
        return  JamDto.builder().jamName("Strwaberry Bliss")
                .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
                .upc(JamLoader.JAM_1_UPC)
                .jamId(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("145.72"))
                .myLocalDate(LocalDate.now())
                .build();
    }
}
