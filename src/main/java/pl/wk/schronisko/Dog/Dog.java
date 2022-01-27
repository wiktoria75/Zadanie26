package pl.wk.schronisko.Dog;

import pl.wk.schronisko.Careteker.Caretaker;

import javax.persistence.*;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Sex sex;
    private int age;
    private int weight;
    @Column(length=1500)
    private String description;
    @ManyToOne ()
    @JoinColumn (name = "caretaker_id")
    private Caretaker caretaker;
    private int helpCount;

    public Dog() {
    }

    public Dog(String name, Sex sex, int age, int weight, String description, Caretaker caretaker, int helpCount) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.description = description;
        this.caretaker = caretaker;
        this.helpCount = helpCount;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Caretaker getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public int getHelpCount() {
        return helpCount;
    }

    public void setHelpCount(int helpCount) {
        this.helpCount = helpCount;
    }
}
