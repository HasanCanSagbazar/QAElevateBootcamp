package model;

public class Category {
    private long id;
    private String name;

    // Constructor
    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
