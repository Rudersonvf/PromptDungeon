package entities;

public class Skill {

    private String name;
    private Double damageMultiplier;
    private Double manaConsume;

    public Skill(String name, Double damageMultiplier, Double manaConsume) {
        this.name = name;
        this.damageMultiplier = damageMultiplier;
        this.manaConsume = manaConsume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(Double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public Double getManaConsume() {
        return manaConsume;
    }

    public void setManaConsume(Double manaConsume) {
        this.manaConsume = manaConsume;
    }

    @Override
    public String toString(){
        return String.format("%s / DM: %.2f%% / MC: %.0f", getName() ,getDamageMultiplier() ,getManaConsume());
    }

}
