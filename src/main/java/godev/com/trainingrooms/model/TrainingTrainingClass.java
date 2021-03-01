package godev.com.trainingrooms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="training_training_class")
public class TrainingTrainingClass {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="training_class_id")
    @JsonProperty("training_class_id")
    private long training_class_id;

    @Column(name="training_id")
    @JsonProperty("training_id")
    private long training_id;

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

    public long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(long training_id) {
        this.training_id = training_id;
    }
}
