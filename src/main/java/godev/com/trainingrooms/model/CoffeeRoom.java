package godev.com.trainingrooms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name="coffee_room")
public class CoffeeRoom {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    @JsonProperty("coffee_duration")
    @Column(name="coffee_duration")
    private int coffee_duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoffeeDuration() {
        return coffee_duration;
    }

    public void setCoffeeDuration(int coffeDuration) {
        this.coffee_duration = coffeDuration;
    }
}
