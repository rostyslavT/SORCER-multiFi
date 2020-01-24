package src.main.dto.recept;

import java.util.List;
import java.util.ArrayList;

public class ReceptDTO {

    private static List<ReceptDTO> receptDTOList = new ArrayList<>();

    private List<Ingreedient> ingreedientList;
    private int amountOfDishes;
    private double price;
    private double calories;

    public ReceptDTO(List<Ingreedient> ingreedientList, int amountOfDishes, double price, double calories) {
        this.ingreedientList = ingreedientList;
        this.amountOfDishes = amountOfDishes;
        this.price = price;
        this.calories = calories;

        receptDTOList.add(this);
    }

    public List<Ingreedient> getIngreedientList() {
        return ingreedientList;
    }

    public void setIngreedientList(List<Ingreedient> ingreedientList) {
        this.ingreedientList = ingreedientList;
    }

    public int getAmountOfDishes() {
        return amountOfDishes;
    }

    public void setAmountOfDishes(int amountOfDishes) {
        this.amountOfDishes = amountOfDishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public static List<ReceptDTO> getReceptDTOList() {
        return receptDTOList;
    }
}