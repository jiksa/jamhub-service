package sage.springcoder.jamhubservice.web.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sage.springcoder.jamhubservice.web.entity.Jam;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;
import sage.springcoder.jamhubservice.web.repositories.JamRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class JamLoader implements CommandLineRunner {

    private final JamRepository jamRepository;

    public JamLoader(JamRepository jamRepository) {
        this.jamRepository = jamRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadJamObjects();
    }

    private void loadJamObjects() {
        if (jamRepository.count() == 0) {
            jamRepository.save(Jam.builder()
                            .jamId(UUID.randomUUID())
                            .jamName("Fruit Fusion Jam")
                            .jamFlavor(JamFlavorEnum.Tropical_Tango_pineapple_mango_passion_fruit.toString())
                            .quantityOnHand(100)
                            .minOnHand(10)
                            .upc(1000345L)
                            .price(new BigDecimal("78.00"))
                    .build());
            jamRepository.save(Jam.builder()
                    .jamId(UUID.randomUUID())
                    .jamName("Strawberry Blast")
                    .jamFlavor(JamFlavorEnum.Strawberry_Delight.toString())
                    .quantityOnHand(100)
                    .minOnHand(10)
                    .upc(1000346L)
                    .price(new BigDecimal("57.00"))
                    .build());
            jamRepository.save(Jam.builder()
                    .jamId(UUID.randomUUID())
                    .jamName("Berrylicious")
                    .jamFlavor(JamFlavorEnum.Blackberry_Bliss.toString())
                    .quantityOnHand(100)
                    .minOnHand(10)
                    .upc(1000347L)
                    .price(new BigDecimal("60.00"))
                    .build());
            jamRepository.save(Jam.builder()
                    .jamId(UUID.randomUUID())
                    .jamName("JamSpice Bravo")
                    .jamFlavor(JamFlavorEnum.Apple_Cinnamon_Spice.toString())
                    .quantityOnHand(100)
                    .minOnHand(10)
                    .upc(1000348L)
                    .price(new BigDecimal("89.00"))
                    .build());
            jamRepository.save(Jam.builder()
                    .jamId(UUID.randomUUID())
                    .jamName("Heavenly Apri")
                    .jamFlavor(JamFlavorEnum.Apricot_Dream.toString())
                    .quantityOnHand(100)
                    .minOnHand(10)
                    .upc(1000349L)
                    .price(new BigDecimal("62.00"))
                    .build());
        }
        //System.out.println("Loaded Jams :" +jamRepository.count());

    }
}
