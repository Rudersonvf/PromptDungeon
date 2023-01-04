package entities;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private Double maxLife;
    private Double life;
    private Double maxMana;
    private Double mana;
    private Double attack;
    private Double defence;
    private Integer maxExperience;
    private Integer experience;
    private Integer level;

    private Backpack backpack;
    private List<Skill> skills = new ArrayList<>();

    public Hero(String name, Double maxLife, Double life, Double maxMana, Double mana, Double attack, Double defence,
            Integer maxExperience, Integer experience, Integer level) {
        this.name = name;
        this.maxLife = maxLife;
        this.life = life;
        this.maxMana = maxMana;
        this.mana = mana;
        this.attack = attack;
        this.defence = defence;
        this.maxExperience = maxExperience;
        this.experience = experience;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Double maxLife) {
        this.maxLife = maxLife;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(Double maxMana) {
        this.maxMana = maxMana;
    }

    public Double getMana() {
        return mana;
    }

    public void setMana(Double mana) {
        this.mana = mana;
    }

    public Double getAttack() {
        return attack;
    }

    public void setAttack(Double attack) {
        this.attack = attack;
    }

    public Double getDefence() {
        return defence;
    }

    public void setDefence(Double defence) {
        this.defence = defence;
    }

    public Integer getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(Integer maxExperience) {
        this.maxExperience = maxExperience;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void LevelUp(){
        if(getExperience() >= maxExperience){
            setMaxLife(getMaxLife() + 50.0);
            setMaxMana(getMaxMana() + 10.0);
            setMaxExperience(getMaxExperience() + 25);
            setAttack(getAttack() + 10.0);
            setDefence(getDefence() + 5.0);
        }
    }

}
