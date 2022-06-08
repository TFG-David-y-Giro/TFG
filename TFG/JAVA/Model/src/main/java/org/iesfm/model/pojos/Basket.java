package org.iesfm.model.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="cart")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private int price;

    public Basket(int id, String username, int price) {
        this.id = id;
        this.username = username;
        this.price = price;
    }

    public Basket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return getId() == basket.getId() && getPrice() == basket.getPrice() && getUsername().equals(basket.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPrice());
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", price=" + price +
                '}';
    }
}
