package org.iesfm.model.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supplier")

public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, country;

    public Supplier() {
    }

    public Supplier(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return getId() == supplier.getId() && getName().equals(supplier.getName()) && getCountry().equals(supplier.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry());
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
