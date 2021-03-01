package godev.com.trainingrooms.repository;

import godev.com.trainingrooms.model.TrainingClassPeople;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TrainingClassPeopleRepository extends CrudRepository<TrainingClassPeople, Integer> {

    @Query(value = "select id, people_id, training_class_id from training_class_people where people_id = :peopleId and training_class_id = :trainingClassId limit 1", nativeQuery = true)
    TrainingClassPeople getTrainingClassPeopleByPeopleId(
            @Param("peopleId") long people_id,
            @Param("trainingClassId") long training_class_id
    );

}
