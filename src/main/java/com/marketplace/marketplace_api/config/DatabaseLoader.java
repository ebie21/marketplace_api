package com.marketplace.marketplace_api.config;

import com.marketplace.marketplace_api.entity.Product;
import com.marketplace.marketplace_api.entity.User;
import com.marketplace.marketplace_api.repository.ProductRepository;
import com.marketplace.marketplace_api.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository, UserRepository userRepository){
        return args -> {
            // Check if the repo is empty Product repo
            if (productRepository.count()==0 && (userRepository.count()==0)){

                //Create a new user(Seller)
                User seller = new User();
                seller.setUsername("John");
                seller.setEmail("john@gmail.com");
                seller.setRole("seller");

                //save the seller
                User savedSeller = userRepository.save(seller);

                //Create new Product
                Product product = new Product();
                product.setName("Headphones");
                product.setPrice(260.00);
                product.setDescription("Headphones product");
                product.setStock(60);
                product.setUser(savedSeller);

                // save the product
                productRepository.save(product);

                System.out.println("Database Seeded Successfully!");

            }

        };

    }
}
