package dev.smo.spring.example.service.inventory;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Inventory {

    @ApplicationModuleListener
    public void onInventoryUpdatedEvent(InventoryUpdatedEvent event) throws InterruptedException {
        System.out.println("An inventory has been started...");
        Thread.sleep(10_000);
        System.out.println("The inventory has been updated [" + event + "]");
    }
}
