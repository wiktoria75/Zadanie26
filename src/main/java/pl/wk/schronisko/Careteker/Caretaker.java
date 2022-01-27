package pl.wk.schronisko.Careteker;

import pl.wk.schronisko.Dog.Dog;

import javax.persistence.*;
import java.util.List;

@Entity
public class Caretaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long telNumber;
    @OneToMany (mappedBy = "caretaker")
    List<Dog> dogs;

    public Caretaker() {
    }

    public Caretaker(String name, Long telNumber, List<Dog> dogs) {
        this.name = name;
        this.telNumber = telNumber;
        this.dogs = dogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
