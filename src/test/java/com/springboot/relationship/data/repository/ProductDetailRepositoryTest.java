package com.springboot.relationship.data.repository;

import com.springboot.relationship.data.entity.Product;
import com.springboot.relationship.data.entity.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest1(){
        Product product= new Product();
        product.setName("펜");
        product.setPrice(5000);
        product.setStock(500);

        productRepository.save(product);

        ProductDetail productDetail= new ProductDetail();
        productDetail.setDescription("언제나 여러운 스프링 부트");
        productDetail.setProduct(product);

        productDetailRepository.save(productDetail);

        System.out.println("savedProduct: "+productDetailRepository.findById(productDetail.getId()).get().getProduct());

        System.out.println("savedProductDetail: "+productDetailRepository.findById(productDetail.getId()).get());

    }
}
