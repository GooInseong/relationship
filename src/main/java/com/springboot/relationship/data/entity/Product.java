package com.springboot.relationship.data.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.*;

// 예제 6.6, 예제 6.30, 6.31, 6.32, 6.33, 6.34, 6.35, 6.36, 6.37
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "product")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @OneToOne(mappedBy = "product") // mappedBy="product" 로 연관관계 주인을 ProductDetail 의 product 필드로 지정하였다.
    @ToString.Exclude               // 연관관계 주인만이 외래키를 등록하거나 수정할 수 있고, 주인이 아닌 쪽은 읽기만 가능하다.
    //양방향으로 연관관계가 설정되면 ToString 을 사용할 때 순환참조가 발생하기때문에 StackOverFlow 가 발생한다. .Exclude 로 설정하여 차단.
    private ProductDetail productDetail;

    @ManyToOne      // 상품과 상품공급자간 다대일 연관관계 설정
    @JoinColumn(name = "provider_number")
    @ToString.Exclude
    private Provider provider;

    @ManyToMany
    @ToString.Exclude
    private List<Producer> producers=new ArrayList<>();

    public void addProducer(Producer producer){
        this.producers.add(producer);
    }
}
