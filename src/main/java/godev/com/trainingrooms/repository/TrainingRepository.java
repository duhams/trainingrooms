package godev.com.trainingrooms.repository;

import godev.com.trainingrooms.model.Training;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TrainingRepository extends CrudRepository<Training, Integer> { }
