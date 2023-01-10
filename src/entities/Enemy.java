package entities;

import enums.Color;

public class Enemy {

    private String name;
    private Double maxLife;
    private Double life;
    private Double attack;
    private Integer enemyFloor;
    private Integer experienceDrop;

    public Enemy(){
    }

    public Enemy(String name, Double maxLife, Double life, Double attack, Integer enemyFloor, Integer experienceDrop) {
        this.name = name;
        this.maxLife = maxLife;
        this.life = life;
        this.attack = attack;
        this.enemyFloor = enemyFloor;
        this.experienceDrop = experienceDrop;
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

    public Double getAttack() {
        return attack;
    }

    public void setAttack(Double attack) {
        this.attack = attack;
    }

    public Integer getEnemyFloor() {
        return enemyFloor;
    }

    public void setEnemyFloor(Integer enemyFloor) {
        this.enemyFloor = enemyFloor;
    }

    public Integer getExperienceDrop() {
        return experienceDrop;
    }

    public void setExperienceDrop(Integer experienceDrop) {
        this.experienceDrop = experienceDrop;
    }

    public String printEnemyStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "\n");
        sb.append(String.format("Life: " + Color.RED + "%.0f" + Color.RESET + "/" + Color.RED + "%.0f\n" + Color.RESET, getLife(), getMaxLife()));
        return sb.toString();
    }

}
