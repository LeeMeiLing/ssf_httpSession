package sg.edu.nus.iss.app.httpSession.model;

import java.io.Serializable;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Item implements Serializable{

    @NotNull(message = "Item name cannot be empty")
    @Size(min=3, message = "Item's name cannot be less than 3 chars")
    private String name;

    @Min(value = 1, message = "Minimum quantity is 1")
    @Digits(integer=5, fraction=2, message = "x quantity is 5 digits and 2 decimal")
    private Float quantity;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getQuantity() {
        return quantity;
    }
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    
}
