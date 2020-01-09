package ro.msg.learning.shop.Utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.Domain.Product;
import ro.msg.learning.shop.Domain.ProductCategory;
import ro.msg.learning.shop.Repository.ProductCategoryRepo;
import ro.msg.learning.shop.Repository.ProductRepo;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(ProductCategoryRepo repo, ProductRepo productRepo) {
        ProductCategory cat = ProductCategory.builder()
                .name("category1")
                .description("descripton1")
                .build();

            repo.save(cat);
            productRepo.save(Product.builder()
                    .name("Product1")
                    .description("DescProd1")
                    .price(10.2)
                    .weight(1.1)
                    .image_url("url")
                    .category(cat)
                    .build()
            );
            return args -> {
                log.info("Data Inserted");
            };
        };
    }

