# README.md - Spring Boot Project with Maven

This repository contains a Spring Boot project with Maven, including a service with a repository method to find the highest priority of prices for specific product, brand, and date.

## Instructions to Run the Project

### Prerequisites

Make sure you have the following prerequisites installed:

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.9.1](https://maven.apache.org/download.cgi)
- [Spring Boot 3.2.2](https://spring.io/projects/spring-boot)

### Steps to Run the Project

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/beatzz921/price-api-springboot.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd price-api-springboot
    ```
3. **Compile the Project with Maven:**

    ```bash
    mvn clean install
    ```

4. **Run the Project with Maven:**

    ```bash
    mvn spring-boot:run
    ```

5. **Access the Application from the Browser:**

   [http://localhost:8080](http://localhost:8080)

## Endpoint Example
### Endpoint #1: /priceapi/v1/active-prices/{brandId}/{productId}/{date}
### Endpoint #1 Exampe: /priceapi/v1/active-prices/35455/1/2020-06-16T21:00Z

## Service and Repository Method Overview

### Service

The service provided by this project can find the highest priority of prices for a specific product, brand, and date.

### Repository Method

The specific method in the repository performing this functionality is annotated with `@Query` and has the following query:

```sql
SELECT price FROM Price price WHERE price.productId = :product AND price.brand.id = :brand AND (price.startDate <= :date AND price.endDate >= :date) ORDER BY price.priority DESC LIMIT 1
```

This method, `findHighestPriorityPriceByProductBrandDate`, takes three parameters: `product` (product ID), `brand` (brand ID), and `date` (specific date). The query seeks the price with the highest priority for the given product and brand on the provided date.

The result is a `PriceEntity` entity containing information about the highest priority price based on the criteria set in the query.
