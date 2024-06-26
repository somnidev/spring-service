# Service

Based upon Josh Longs presentation [Bootiful Spring Boot 3.x by Josh Long @ Spring I/O 2024](https://www.youtube.com/watch?v=2Aa5uQozbJQ).

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
curl -H "content-type:application/json" -d '{ "lineItems": [ { "quantity":2, "product":42}]}' -XPOST http://localhost:8080/service
```