package ru.vlad.altituda.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class Producer {

    private int id;
    @Size(max = 60,message = "Это поле не должно превышать больше 60 символов")
    @NotEmpty(message = "Вы не ввели название")
    private String producer;

    public Producer(int id,String producer) {
        this.id = id;
        this.producer = producer;
    }
    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                '}';
    }
}
