package pl.wk.schronisko.Dog;

public enum Sex {
    MALE("pies"), FEMALE("sunia");

    String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
