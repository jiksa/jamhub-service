package sage.springcoder.jamhubservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JamDto {

    private UUID jamId;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String jamName;

    private JamFlavorEnum jamFlavor;

    private Long upc;
    private BigDecimal price;

    private Integer quantityOnHand;


}
