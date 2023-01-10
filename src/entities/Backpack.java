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

    public void addItem(Potion potion) {
        if (weight <= maxWeight) {

            boolean answer = potions.contains(potion);
            if (answer == false) {
                potions.add(potion);
            } 
            else {
                potions.stream().filter(p -> p.equals(potion))
                        .forEach(p -> p.setQuantity(p.getQuantity() + potion.getQuantity()));
            }
            setWeight(getWeight() + potion.getItemWeight());
        } 
        else {
            System.out.println("Bag is full! Delete something...");
        }
    }

    public void printBackpackItems(){
        if(getWeight() <= 0){
            System.out.println("The backpack is empty!");
        }
        else{
            for(Potion potion : getPotions()){
                System.out.println("[" + getPotions().indexOf(potion) + "]" + potion);
            }
        }
    }

    public String printBackpack(){
        return String.format("Weight: %d  /  Max Weight: %d", getWeight(), getMaxWeight());
    }

}
