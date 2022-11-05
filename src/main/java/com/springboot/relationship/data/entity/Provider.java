package com.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Provider extends BaseEntity{

    /* 상품과 상품공급업체의 다대일 일대다 연관관계 매핑을 위한 엔터티 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)  //FetchType.EAGER 로 설정한 이유는, Provider 를 통해 Product 객체를 조회 하기 위해서 이다.
    @ToString.Exclude
    List<Product> productList=new ArrayList<>();
    /*일대다 양방향 연관관계 설정. 연관관계 주인을 Product 필드에 provider 로 설정
    * 일대다 의 관계에서 하나의 상품공급업체가 여러개의 상품을 가지고 있을 수 있으므로
    * Collection 으로 설정하였다.*/

}
