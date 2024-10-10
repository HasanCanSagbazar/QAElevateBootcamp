package model;

public class Tag {
    private long id;
    private String name;

    // Constructor
    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
