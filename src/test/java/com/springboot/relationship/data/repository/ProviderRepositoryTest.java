package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProviderRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Test
    void relationshipTest1(){
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

    @Test
    void relationshipTest2(){
        /* 일대다 연관관계 테스트*/
        Provider provider= new Provider();
        provider.setName("XX상사");

        providerRepository.save(provider);

        Product product1= new Product();
        product1.setName("마우스");
        product1.setPrice(32000);
        product1.setStock(100);
        product1.setProvider(provider);

        Product product2= new Product();
        product2.setName("키보드");
        product2.setPrice(59000);
        product2.setStock(10);
        product2.setProvider(provider);

        Product product3= new Product();
        product3.setName("모니터");
        product3.setPrice(300000);
        product3.setStock(15);
        product3.setProvider(provider);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> productList=providerRepository.findById(provider.getId()).get().getProductList();

        for(Product product:productList){
            System.out.println("Product: "+product);
        }


    }
}
