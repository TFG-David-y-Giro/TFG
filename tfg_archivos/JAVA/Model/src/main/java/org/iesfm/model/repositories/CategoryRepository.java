package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.pojos.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {

}
