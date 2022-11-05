package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    void relationshipTest(){
        //테스트 데이터 설정
        Provider provider= new Provider();
        provider.setName("00물산");

        providerRepository.save(provider);

        Product product= new Product();
        product.setName("가위");
        product.setPrice(10000);
        product.setStock(100);
        product.setProvider(provider);

        productRepository.save(product);

        System.out.println("Product: "+productRepository.findById(1L).orElseThrow(RuntimeException::new));
        System.out.println("Provider: "+productRepository.findById(1L).orElseThrow(RuntimeException::new).getProvider());
    }
}
