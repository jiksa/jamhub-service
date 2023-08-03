package sage.springcoder.jamhubservice.services.inventory;

import java.util.UUID;

public interface JamInventoryService {

    Integer getOnHandInventory(UUID jamId);
}
