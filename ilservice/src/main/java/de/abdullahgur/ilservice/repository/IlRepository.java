package de.abdullahgur.ilservice.repository;

import de.abdullahgur.ilservice.module.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

// bu sayede mongodb ile database bağlanmasını yaptık
public interface IlRepository extends MongoRepository<Il, String> {
}
