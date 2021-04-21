package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private int subcategories;
    @NotEmpty(message = "Описание товара должно быть заполнено!!!")
    private String description;
    private int quantity;
    private int producer;
    private String photo;
    private double price;

    public Product(int id, int subcategories, String description, int quantity, int producer, String photo, double price) {
        this.id = id;
        this.subcategories = subcategories;
        this.description = description;
        this.quantity = quantity;
        this.producer = producer;
        this.photo = photo;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", subcategories=" + subcategories +
                ", description=" + description +
                ", quantity=" + quantity +
                ", producer=" + producer +
                ", photo=" + photo +
                ", price=" + price +
                '}';
    }
}
