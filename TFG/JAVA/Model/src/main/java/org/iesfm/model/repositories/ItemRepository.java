package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.pojos.Item;
import org.iesfm.model.pojos.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM item i WHERE i.category=:category"
    )
    List<Item> getItemsByCategory(@Param("category") String category);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM item WHERE supplier=:supplier"
    )
    List<Item> getItemsBySupplier(@Param("supplier") String supplier);

}
