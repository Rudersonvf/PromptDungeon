package entities;

public class Potion {
    
    private String name;
    private Double itemWeight;
    private Double recoveryValue;
    private Integer quantity;
    
    public Potion(String name, Double itemWeight, Double recoveryValue, Integer quantity) {
        this.name = name;
        this.itemWeight = itemWeight;
        this.recoveryValue = recoveryValue;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Double getRecoveryValue() {
        return recoveryValue;
    }

    public void setRecoveryValue(Double recoveryValue) {
        this.recoveryValue = recoveryValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
