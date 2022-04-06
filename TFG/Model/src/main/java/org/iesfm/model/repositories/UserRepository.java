package org.iesfm.model.repositories;

import org.iesfm.model.pojos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

}
