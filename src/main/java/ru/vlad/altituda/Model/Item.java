package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Item {
    private Product product = new Product();
    public int quantity;
    private String subCategory;


    public Item(Product product, int quantity, String subCategory) {
        this.product = product;
        this.quantity = quantity;
        this.subCategory = subCategory;
    }
}
