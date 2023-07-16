package sage.springcoder.jamhubservice.web.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Jam {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36, columnDefinition = "varchar", updatable = false,nullable = false)
    private UUID jamId;

    @Version
    private Integer version;

    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    private OffsetDateTime lastModifiedDate;

    private String jamName;

    private String jamFlavor;

    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    private Integer minOnHand;
    private Integer quantityOnHand;
}
