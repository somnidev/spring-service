package dev.smo.spring.example.service.inventory;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Inventory {

    @EventListener
    void on(InventoryUpdatedEvent event) {
        System.out.println("The inventory has been updated [" + event + "]");
    }
}
