package godev.com.trainingrooms.repository;

import godev.com.trainingrooms.model.TrainingTrainingClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TrainingTrainingClassRepository extends CrudRepository<TrainingTrainingClass, Integer> {

    @Query(value = "select * from training_training_class where training_id = :trainingId", nativeQuery = true)
    List<TrainingTrainingClass> getTrainingTrainingClassByTraining_id(@Param("trainingId") long trainingId);

}
