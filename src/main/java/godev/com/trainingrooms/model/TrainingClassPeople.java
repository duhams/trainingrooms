package godev.com.trainingrooms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="training_class_people")
public class TrainingClassPeople {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="training_class_id")
    @JsonProperty("training_class_id")
    private long training_class_id;

    @Column(name="people_id")
    @JsonProperty("people_id")
    private long people_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTraining_class_id() {
        return training_class_id;
    }

    public void setTraining_class_id(long training_class_id) {
        this.training_class_id = training_class_id;
    }

    public long getPeople_id() {
        return people_id;
    }

    public void setPeople_id(long people_id) {
        this.people_id = people_id;
    }
}
