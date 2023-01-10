package entities;

public class Potion {
    
    private String name;
    private Integer itemWeight;
    private Double recoveryValue;
    private Integer quantity;

    public Potion(){
    }
    
    public Potion(String name, Integer itemWeight, Double recoveryValue, Integer quantity) {
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

    public Integer getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Integer itemWeight) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Potion other = (Potion) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return String.format("%s / RV: %.0f / QT: %d", getName(), getRecoveryValue(), getQuantity());
    }
}
