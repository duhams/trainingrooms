package godev.com.trainingrooms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="training_class")
public class TrainingClass {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="coffee_room_id")
    @JsonProperty("coffee_room_id")
    private long coffee_room_id;

    @Column(name="max_capacity")
    @JsonProperty("max_capacity")
    private int maxCapacity;

    @Column(name="training_id")
    @JsonProperty("training_id")
    private int training_id;

    public int getTraining_id() {
        return training_id;
    }

    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCoffee_room_id() {
        return coffee_room_id;
    }

    public void setCoffee_room_id(long coffee_room_id) {
        this.coffee_room_id = coffee_room_id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
