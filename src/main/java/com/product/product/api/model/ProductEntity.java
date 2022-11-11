package com.product.product.api.model;

import javax.persistence.*;
import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_entity_id")
    PaymentEntity paymentEntity;

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void PaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }
}
