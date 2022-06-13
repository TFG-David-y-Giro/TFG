package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Supplier findByName(String name);

    @Query(
            nativeQuery = true,
            value = "SELECT name FROM supplier"
    )
    List<String> getSuppliersNames();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM supplier WHERE country=:country"
    )
    List<Supplier> getSuppliersByCountry(@Param("country") String country);

}
