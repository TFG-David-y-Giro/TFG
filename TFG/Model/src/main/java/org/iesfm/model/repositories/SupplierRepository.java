package org.iesfm.model.repositories;

import org.iesfm.model.pojos.Supplier;
import org.iesfm.model.pojos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, Integer> {

}
