package godev.com.trainingrooms.repository;

import godev.com.trainingrooms.model.TrainingClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TrainingClassRepository extends CrudRepository<TrainingClass, Integer> {

    @Query(value = "select * from training_class where id = :trainingClassId", nativeQuery = true)
    TrainingClass getTrainingClassById(@Param("trainingClassId") long trainingClassId);

    @Query(
            value="select max_capacity,(select count(*) from training_class_people where training_class_people.training_class_id = training_class.id) as 'qtd', IF((select count(*) from training_class_people where training_class_people.training_class_id = training_class.id) >= training_class.max_capacity, 1, 0) isExceeded from training_class where id = :trainingClassId",
            nativeQuery = true
    )
    Map<String, Object> getTrainingClassExceededMaximumPeoples(@Param("trainingClassId") long trainingClassId);

    @Query(
            value="select max_capacity,(select count(*) from training_class_people where training_class_people.training_class_id = training_class.id) as 'qtd', IF((select count(*) from training_class_people where training_class_people.training_class_id = training_class.id) >= training_class.max_capacity, 1, 0) isExceeded, training_id from training_class where training_id = :trainingId",
            nativeQuery = true
    )
    List<Map<String, Object>> getTrainingClassLimitsByTrainingId(@Param("trainingId") long trainingId);

    @Query(
            value="select max_capacity,(select count(*) from training_class_people where training_class_people.training_class_id = training_class.id) as 'qtd' from training_class where id = :trainingClassId limit 1",
            nativeQuery = true
    )
    Map<String, Object> getTrainingClassPeopleQtd(@Param("trainingClassId") long trainingId);

    @Query(value = "select * from training_class where id = :trainingClassId limit 1", nativeQuery = true)
    TrainingClass findById(long trainingClassId);
}
