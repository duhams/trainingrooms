package godev.com.trainingrooms.repository;

import godev.com.trainingrooms.model.People;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PeopleRepository extends CrudRepository<People, Integer> { }
