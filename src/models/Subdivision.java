package models;

public class Subdivision {

    private int id;
    private String name;

    public Subdivision(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subdivision() { }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
