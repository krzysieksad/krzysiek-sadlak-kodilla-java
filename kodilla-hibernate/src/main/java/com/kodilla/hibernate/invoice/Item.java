package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    public Item() {
    }

    /**
     * Item on invoice.
     *
     * @param product  product name
     * @param price    price of product
     * @param quantity quantity of product
     * @param value    price * quantity
     */
    public Item(final Product product, final BigDecimal price, final int quantity, final BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
