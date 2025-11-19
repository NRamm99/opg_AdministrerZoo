package models;

public class Species {
    int id;
    String name;
    String latinName;

    public Species(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    public Species(int id, String name, String latinName) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
    }

    public String getName() {
        return name;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "#" + id + " - Name: " + name + " - Latin Name: " + latinName;
    }
}
