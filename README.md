# Service

Based upon Josh Longs presentation [Bootiful Spring Boot 3.x by Josh Long @ Spring I/O 2024](https://www.youtube.com/watch?v=2Aa5uQozbJQ).

## What are the advantages of spring modulith vs microservices?

Perplexity answers this question with the following answer:

Spring Modulith offers several advantages over microservices architecture, while still providing some of the benefits of modular design:

1. Simplicity and maintainability: Spring Modulith retains the simplicity of a monolithic codebase, making it easier for developers to navigate and maintain compared to distributed microservices[2].

2. Clear boundaries with less complexity: Modulith emphasizes clear module boundaries and separation of concerns, similar to microservices, but without the operational complexities of a distributed system[2].

3. Better performance: By reducing network communication and running modules in the same process or hardware, Modulith can achieve better performance compared to distributed microservices[2].

4. Easier deployment: Modulith applications are assembled into a single deployment unit, simplifying the deployment process compared to coordinating multiple microservices[2].

5. Cost-effective: Modulith can be more cost-effective by consolidating functionalities within a single codebase, eliminating the need for complex infrastructure setups required for microservices. Amazon reportedly reduced costs by 90% for one of their services by using a similar approach[2].

6. Evolutionary approach: Modulith offers a gradual path from monolithic to modular architecture, allowing developers to extract modules into microservices as needed in the future[2].

7. Reduced development overhead: Compared to microservices, Modulith has less configuration complexity and reduced development overhead[2].

8. Transactional event handling: Spring Modulith provides a transaction event publication log, allowing for easier integration between application modules in transactional contexts[1].

9. Built-in documentation and observability: Spring Modulith offers features for deriving developer documentation from the application module structure and provides runtime observability at the module level[1].

10. Enforced modularity: Spring Modulith helps enforce and verify logical modules within a Spring Boot application, ensuring better adherence to modular design principles[1][3].

While microservices offer benefits like independent scalability and technology diversity, Spring Modulith provides a balanced approach that combines the advantages of monolithic simplicity with modular design, making it suitable for many applications that don't require the full complexity of a microservices architecture[2][4].

Citations:
- [1] https://spring.io/blog/2022/10/21/introducing-spring-modulith/
- [2] https://blog.worldline.tech/2024/01/23/modulith.html
- [3] https://blog.frankel.ch/spring-modulith-modularity-maturity/
- [4] https://debugagent.com/is-it-time-to-go-back-to-the-monolith
- [5] https://jaxlondon.com/microservices/modular-monolith-architecture-vs-microservices/

## Docker

Use docker compose to start postgres.

```bash
docker compose up -d
```

Stop it.

```bash
docker compose down
```

## Rest-Api

In order to create a new `order` use the following curl command.

```bash
curl -H "content-type:application/json" -d '{ "lineItems": [ { "quantity":2, "product":42}]}' -XPOST http://localhost:8080/orders
```

## Resources 

- [Baeldung - Introduction to Spring Modulith](https://www.baeldung.com/spring-modulith)
- [Piotr's Techblog - Guide to Modulith with Spring Boot](https://piotrminkowski.com/2023/10/13/guide-to-modulith-with-spring-boot/).
- [The Modern Monolith, with Spring Modulith by Cora Iberkleid @ Spring I/O 2024](https://www.youtube.com/watch?v=7c6xXmJvDjo)