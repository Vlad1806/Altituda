package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SubCategories {
    private int id;
    private String name;
    private String description;
    private int category;

    public SubCategories(int id, String name, String description, int category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
