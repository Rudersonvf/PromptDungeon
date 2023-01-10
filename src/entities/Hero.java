package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Color;

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
        setLevel(getLevel() + 1);
        setMaxLife(getMaxLife() + 80.0);
        setLife(getMaxLife());
        setMaxMana(getMaxMana() + 10.0);
        setMana(getMaxMana());
        setMaxExperience((getMaxExperience() + 200));
        setAttack(getAttack() + 15.0);
        setDefence(getDefence() + 5.0);
        setExperience(0);
      
    }

    public void usePotion(Integer index){
        try {
            if(getBackpack().getPotions().get(index).getName().contains("Life")){
                getBackpack().getPotions().get(index).setQuantity(getBackpack().getPotions().get(index).getQuantity() - 1);
                if(getLife() + getBackpack().getPotions().get(index).getRecoveryValue() >= getMaxLife() ){
                    setLife(getMaxLife());
                }
                else{
                    setLife(getLife() + getBackpack().getPotions().get(index).getRecoveryValue());
                }
            }
            else if(getBackpack().getPotions().get(index).getName().contains("Mana")){
                getBackpack().getPotions().get(index).setQuantity(getBackpack().getPotions().get(index).getQuantity() - 1);
                if(getMana() + getBackpack().getPotions().get(index).getRecoveryValue() >= getMaxMana() ){
                    setMana(getMaxMana());
                }
                else{
                    setMana(getMana() + getBackpack().getPotions().get(index).getRecoveryValue());
                }
            }
            else if(getBackpack().getPotions().get(index).getName().contains("Strength")){
                getBackpack().getPotions().get(index).setQuantity(getBackpack().getPotions().get(index).getQuantity() - 1);
                setAttack(getAttack() + getBackpack().getPotions().get(index).getRecoveryValue());
            }
            else{
                getBackpack().getPotions().get(index).setQuantity(getBackpack().getPotions().get(index).getQuantity() - 1);
                setDefence(getDefence() + getBackpack().getPotions().get(index).getRecoveryValue());
            }
            getBackpack().setWeight(getBackpack().getWeight() - getBackpack().getPotions().get(index).getItemWeight());
            System.out.printf("You used %s\n", getBackpack().getPotions().get(index).getName());
            removePotion(index);
        } catch (Exception e) {
            System.out.println("Error: Out of index range");
        }
        
    }

    public void removePotion(int index){
        try {
            if(getBackpack().getPotions().get(index).getQuantity() <= 0){
                getBackpack().getPotions().remove(index);
            }
        } catch (Exception e) {
            System.out.println("Error: out of index range");
        }
        
    }

    public void deletePotion(int index){
        
        getBackpack().setWeight(getBackpack().getWeight() - (getBackpack().getPotions().get(index).getQuantity() * getBackpack().getPotions().get(index).getItemWeight()));
        getBackpack().getPotions().remove(index);
    }

    public void printSkill(){
        if(skills.size() >= 1){
            for(Skill skill : skills){
                System.out.println("[" + getSkills().indexOf(skill) + "] " + skill);
            }
        }
        else{
            System.out.println("You dont have Skills");
        }
        
    }

    public void newSkill(){
        if(getExperience() == 0){
            switch(getLevel()){
                case 2 -> {getSkills().add(new Skill("Power Stab", 1.38, 15.0));
                System.out.println("You acquired a new skill!");}
                case 4 -> {getSkills().add(new Skill("Whirlwind", 1.65, 20.0));
                System.out.println("You acquired a new skill!");}
                case 6 -> {getSkills().add(new Skill("Divine Strike", 2.0, 30.0));
                System.out.println("You acquired a new skill!");}
            }
        }
    }

    public String printHeroStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "\n");
        sb.append(String.format("Life: " + Color.RED + "%.0f" + Color.RESET + "/" + Color.RED + "%.0f\n" + Color.RESET, getLife(), getMaxLife()));
        sb.append(String.format("Mana: " + Color.BLUE + "%.0f" + Color.RESET + "/" + Color.BLUE + "%.0f\n" + Color.RESET, getMana(), getMaxMana()));
        return sb.toString();
    }

    public String printHeroBackpackStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "\n");
        sb.append(String.format("Life: " + Color.RED + "%.0f" + Color.RESET + "/" + Color.RED + "%.0f\n" + Color.RESET, getLife(), getMaxLife()));
        sb.append(String.format("Mana: " + Color.BLUE + "%.0f" + Color.RESET + "/" + Color.BLUE + "%.0f\n" + Color.RESET, getMana(), getMaxMana()));
        sb.append(String.format("Atk: %.0f  /  Def: %.0f", getAttack(), getDefence()));
        return sb.toString();
    }

    public String printHeroFullStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "\n");
        sb.append(String.format("Level: %d\n", getLevel()));
        sb.append(String.format("Life: " + Color.RED + "%.0f" + Color.RESET + "/" + Color.RED + "%.0f\n" + Color.RESET, getLife(), getMaxLife()));
        sb.append(String.format("Mana: " + Color.BLUE + "%.0f" + Color.RESET + "/" + Color.BLUE + "%.0f\n" + Color.RESET, getMana(), getMaxMana()));
        sb.append(String.format("EXP: %d/%d\n", getExperience(), getMaxExperience()));
        sb.append(String.format("Atk: %.0f  /  Def: %.0f", getAttack(), getDefence()));
        return sb.toString();
    }

}
