package ro.msg.learning.shop.Utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.Domain.*;
import ro.msg.learning.shop.Repository.*;

import java.sql.Timestamp;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ProductCategoryRepo repo, ProductRepo productRepo, CustomerRepo customerRepo, LocationRepo locationRepo,
                                   OrderDetailRepo orderDetailRepo, OrderRepo orderRepo, RevenueRepo revenueRepo, StockRepo stockRepo, SupplierRepo supplierRepo) {

        ProductCategory cat = ProductCategory.builder()
                .name("category1")
                .description("descripton1")
                .build();

        Supplier supplier = Supplier.builder()
                .name("supplier1")
                .build();

        Product prod = Product.builder()
                .name("Product1")
                .description("DescProd1")
                .price(10.2)
                .weight(1.1)
                .image_url("url")
                .category(cat)
                .supplier(supplier)
                .build();

        Product prod2 = Product.builder()
                .name("Product2")
                .description("DescProd2")
                .price(10.2)
                .weight(1.1)
                .image_url("url")
                .category(cat)
                .supplier(supplier)
                .build();

        Customer customer = Customer.builder()
                .first_name("firstname1")
                .last_name("lastname1")
                .username("username1")
                .password("password1")
                .email_address("email1")
                .build();

        Location location = Location.builder()
                .name("location1")
                .country("country1")
                .city("city1")
                .street_address("street1")
                .build();

        Location location2 = Location.builder()
                .name("location2")
                .country("country2")
                .city("city2")
                .street_address("street2")
                .build();

        Orders orders = Orders.builder()
                .shipped_from(location)
                .customer_id(customer)
                .create_at(new Timestamp(System.currentTimeMillis()))
                .country("orderCountry1")
                .city("orderCity1")
                .street_address("orderStreet1")
                .build();

        Revenue revenue = Revenue.builder()
                .location(location)
                .date(new Timestamp(System.currentTimeMillis()))
                .sum(20.5)
                .build();

        Stock stock = Stock.builder()
                .product(prod)
                .location(location)
                .quantity(50)
                .build();

        Stock stock2 = Stock.builder()
                .product(prod2)
                .location(location)
                .quantity(50)
                .build();

        Stock stock3 = Stock.builder()
                .product(prod2)
                .location(location2)
                .quantity(150)
                .build();

        OrderDetail orderDetail = OrderDetail.builder()
                .orders(orders)
                .product(prod)
                .quantity(20)
                .build();

        repo.save(cat);
        supplierRepo.save(supplier);
        customerRepo.save(customer);
        productRepo.save(prod);
        productRepo.save(prod2);
        locationRepo.save(location);
        locationRepo.save(location2);
        orderRepo.save(orders);
        revenueRepo.save(revenue);
        orderDetailRepo.save(orderDetail);
        stockRepo.save(stock);
        stockRepo.save(stock2);
        stockRepo.save(stock3);

        return args -> {
            log.info("Data Inserted");
        };
    }

    ;
}

