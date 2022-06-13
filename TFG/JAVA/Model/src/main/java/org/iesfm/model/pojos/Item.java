package org.iesfm.model.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;


    @JoinColumn(name = "category",
            referencedColumnName = "name",
            insertable = false,
            updatable = false)
    private String category;


    @JoinColumn(name = "supplier",
            referencedColumnName = "name",
            insertable = false,
            updatable = false)
    private String supplier;
    private int quantity;

    public Item() {
    }

    public Item(int id, String name, int price, String category, String supplier, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId() == item.getId() && getPrice() == item.getPrice() && getQuantity() == item.getQuantity() && getName().equals(item.getName()) && getCategory().equals(item.getCategory()) && getSupplier().equals(item.getSupplier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getCategory(), getSupplier(), getQuantity());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", supplier='" + supplier + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
