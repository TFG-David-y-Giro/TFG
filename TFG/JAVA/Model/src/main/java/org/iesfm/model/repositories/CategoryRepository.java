package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Category findByName(String name);

}
