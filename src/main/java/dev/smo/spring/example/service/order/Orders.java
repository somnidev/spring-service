package dev.smo.spring.example.service.order;

import dev.smo.spring.example.service.inventory.InventoryUpdatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

public class Orders {
}

@Transactional
@RestController
class OrdersController {

    private final OrderRepository repository;

    private final ApplicationEventPublisher publisher;

    public OrdersController(OrderRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return repository.findAll();
    }

    @PostMapping("/orders")
    void createOrder(@RequestBody Order order) {
        var saved = this.repository.save(order);
        System.out.println("Order created: " + saved);
        saved.lineItems().forEach(li -> publisher.publishEvent(new InventoryUpdatedEvent(li.product(), li.quantity())));
    }
}

@Repository
interface  OrderRepository extends ListCrudRepository<Order, Integer> {}

@Table("orders_line_items")
record LineItem(@Id int id, int product, int quantity) {}

@Table("orders")
record Order(@Id int id, Set<LineItem> lineItems) {}

