package dev.smo.spring.example.service.order;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

public class Orders {
}

@RestController("/service")
@ResponseBody
class OrdersController {

    private final OrderRepository repository;

    public OrdersController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    void createOrder(@RequestBody Order order) {
        var saved = this.repository.save(order);
        System.out.println("Order created: " + saved);
    }
}

@Repository
interface  OrderRepository extends ListCrudRepository<Order, Integer> {}

@Table("orders_line_items")
record LineItem(@Id int id, int productId, int quantity) {}

@Table("orders")
record Order(@Id int id, Set<LineItem> lineItems) {}

