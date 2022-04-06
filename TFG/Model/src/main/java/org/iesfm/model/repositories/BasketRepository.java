package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Basket;
import org.iesfm.model.pojos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BasketRepository extends MongoRepository<Basket, Integer> {

}
