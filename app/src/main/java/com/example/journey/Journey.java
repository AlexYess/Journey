package com.example.journey;

import java.util.List;

public class Journey {
    private int id;
    private String name;
    private final int cost;
    private final String time;

    private String location;
    private String description;
    private int imageResourceId;
    private List<String> tags; // Добавлено поле для хранения тегов

    public Journey(int id, String name, int cost, String time, String location, String description, int imageResourceId, List<String> tags) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.time = time;
        this.location = location;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.tags = tags;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public String getTime() {
        return time;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getTag1() {
        return tags.get(0);
    }

    public String getTag2() {
        return tags.get(1);
    }

    public String getTag3() {
        return tags.get(2);
    }

    public String getTag4() {
        return tags.get(3);
    }

    public String getTag5() {
        return tags.get(4);
    }
}
