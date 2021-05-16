package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
public class Orders {
    private int id;
    private int product;
    private int quantity;

    private String receiving;
    private Timestamp timeOrder;

    public Orders(int id, int product, int quantity, String receiving, Timestamp timeOrder) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.receiving = receiving;
        this.timeOrder = timeOrder;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", receiving=" + receiving +
                ", timeOrder=" + timeOrder +
                '}';
    }
}

