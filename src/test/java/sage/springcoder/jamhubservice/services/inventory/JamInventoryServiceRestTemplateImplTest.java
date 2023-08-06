package sage.springcoder.jamhubservice.services.inventory;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import sage.springcoder.jamhubservice.web.bootstrap.JamLoader;

import java.util.UUID;

@Disabled // utility for manual testing
@SpringBootTest
public class JamInventoryServiceRestTemplateImplTest {

    @Autowired
    JamInventoryService jamInventoryService;


    @Test
    void getOnhandInventory() {

        //todo evolve to use UPC
       //  Integer qoh = jamInventoryService.getOnHandInventory(JamLoader.JAM_1_UUID);

       // System.out.println(qoh);

    }
}
