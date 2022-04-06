package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Item;
import org.iesfm.model.pojos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, Integer> {

}
