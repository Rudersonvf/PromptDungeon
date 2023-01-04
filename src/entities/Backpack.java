package entities;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private Integer maxWeight;
    private Integer weight;

    private List<Potion> potions = new ArrayList<>();

    public Backpack(Integer maxWeight, Integer weight) {
        this.maxWeight = maxWeight;
        this.weight = weight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Potion> getPotions() {
        return potions;
    }

}
