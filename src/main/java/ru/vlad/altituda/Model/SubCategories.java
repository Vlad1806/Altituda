package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class SubCategories {
    private int id;
    @Size(max = 50,message = "Название не должно превышать больше 50 символов")
    @NotEmpty(message = "Вы не ввели название")
    private String name;
    @NotEmpty(message = "Вы не ввели описание")
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
