package org.iesfm.model.pojos;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name ="cart")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private List<Item> items;

    public Basket(int id, String username, List<Item> items) {
        this.id = id;
        this.username = username;
        this.items = items;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id && Objects.equals(username, basket.username) && Objects.equals(items, basket.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, items);
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", items=" + items +
                '}';
    }
}
