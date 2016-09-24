package com.webportal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by amarendra on 24/09/16.
 */
@RepositoryRestResource
public interface ComputerRepository extends MongoRepository<Computer, Long> {
}
