package com.example.tp_list_with_images;

import java.util.HashMap;
import java.util.Map;

public class City {
    public String name;
    public String description;
    public int imageSrc;

    public City(String name, String description, int imageSrc){
        this.name = name;
        this.description = description;
        this.imageSrc = imageSrc;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("description", description);
        map.put("imageSrc", imageSrc);
        return map;
    }
}
