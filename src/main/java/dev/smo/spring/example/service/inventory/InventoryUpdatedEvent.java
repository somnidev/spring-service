package dev.smo.spring.example.service.inventory;

public record InventoryUpdatedEvent(int product, int quantity) {
}
