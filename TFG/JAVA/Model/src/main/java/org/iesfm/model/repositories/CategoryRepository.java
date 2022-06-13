package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);

    @Query(
            nativeQuery = true,
            value = "SELECT name FROM category"
    )
    List<String> getCategoryNames();

}
