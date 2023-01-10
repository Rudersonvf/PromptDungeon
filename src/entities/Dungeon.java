package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.Color;
import enums.Dice;

public class Dungeon {

    private final String path = "C:\\temp\\enemies.csv";
    
    private Integer floor;
    private Integer room;

    private Hero hero;
    private Enemy spawnedEnemy = new Enemy();
    private List<Enemy> enemies = new ArrayList<>();

    public Dungeon() {
    }
    
    public Dungeon(Integer floor, Integer room) {
        this.floor = floor;
        this.room = room;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy getSpawnedEnemy() {
        return spawnedEnemy;
    }

    public void setSpawnedEnemy(Enemy spawnedEnemy) {
        this.spawnedEnemy = spawnedEnemy;
    }


    public void addEnemiesToList(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.toString().split(",");
                enemies.add(new Enemy(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]), Double.parseDouble(fields[3]),
                Integer.parseInt(fields[4]), Integer.parseInt(fields[5])));
                line = br.readLine();
            }
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Generates a random enemy from the list according to dungeon floor
    public Enemy spawnEnemy(){
        List<Enemy> enemySpawList = new ArrayList<>();
        Enemy enemy = new Enemy(null, null, null, null, null, null);
        Random random = new Random();
        final int minFloorRange = 1;
        if(enemies != null){
            enemies.removeAll(enemies);
            addEnemiesToList();
        }
        for(Enemy spawEnemy : enemies){
            if(spawEnemy.getEnemyFloor() <= getFloor() && spawEnemy.getEnemyFloor() > getFloor() - minFloorRange){
                enemySpawList.add(spawEnemy);
            }
        }
        int index = random.nextInt(enemySpawList.size());
        enemy = enemySpawList.get(index);
        return enemy;
    }

    //Generates a random potion according to dungeon floor
    public Potion generatePotion(){
        int diceResult = Dice.rollDice();
        Potion potion = new Potion();
        switch(diceResult){
            case 1,3,5:
            if(getFloor() < 3){
                potion = new Potion("Potion of Life", 1, 100.0, 1);
            }
            else if(getFloor() < 6){
                potion = new Potion("Grand Potion of Life", 1, 200.0, 1);
            }
            else{
                potion = new Potion("Elixir of Life", 1, 300.0, 1);
            }
            break;
            case 2,4,6:
            if(getFloor() < 3){
                potion = new Potion("Potion of Mana", 1, 15.0, 1);
            }
            else if(getFloor() < 6){
                potion = new Potion("Grand Potion of Mana", 1, 25.0, 1);
            }
            else{
                potion = new Potion("Elixir of Mana", 1, 40.0, 1);
            }
            break;
            case 7:
                potion = new Potion("Potion of Strength", 2, 5.0, 1);
            break;
            case 8:
                potion = new Potion("Potion of Defence", 2, 5.0, 1);
            break;
        }
        System.out.println("You found a " + potion.getName());
        return potion;
    }

    public String updateDungeon(){
        final int aux = 1;
        if(getRoom() < 10 && hero.getLife() > 0){
            setRoom(getRoom() + aux);
            return "You advanced to next room...";
        }
        else if(getRoom() >= 10 && hero.getLife() > 0){
            setRoom(aux);
            setFloor(getFloor() + aux);
            return "You advanced to next floor!\nPreprare to hardener battles...";
        }
        else{
            return Color.RED + "YOU DIE!!!" + Color.RESET; 
        }
    }

    public boolean haveMana(Integer index){
        try {
            if(hero.getMana()>= hero.getSkills().get(index).getManaConsume()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Out of index range");
        }
        return false;
    }

    public boolean isGameOver(){
        if(getHero().getLife() <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEndDungeon(){
        if(getFloor() > 10){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEndTurn(int turn){
        if(turn != 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEndBattle(){
        if(spawnedEnemy.getLife() <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String enemyAttack(){
        double damage = 0.0;
        if(spawnedEnemy.getAttack() <= hero.getDefence()){
            damage = 1.0;
        }
        else{
            damage =  spawnedEnemy.getAttack() - hero.getDefence();
        }
        if(hero.getLife() - damage < 0.0){
            hero.setLife(0.0);
        }
        else{
            hero.setLife(hero.getLife() - damage);
        }
        return String.format("Enemy does %.0f of damage!", damage);
    }

    public String heroNormalAttack(){
        if(spawnedEnemy.getLife() - hero.getAttack() > 0){
            spawnedEnemy.setLife(spawnedEnemy.getLife() - hero.getAttack());
        }
        else{
            spawnedEnemy.setLife(0.0);
        }
        return String.format("You cause %.0f of damage!", hero.getAttack());
    }

    public String heroSkillAttack(Integer index) throws IndexOutOfBoundsException{
        double damage = hero.getAttack() * hero.getSkills().get(index).getDamageMultiplier();
        hero.setMana(hero.getMana() - hero.getSkills().get(index).getManaConsume()); //decrease mana
        if(spawnedEnemy.getLife() - damage > 0){
            spawnedEnemy.setLife(spawnedEnemy.getLife() - damage);
        }
        else{
            spawnedEnemy.setLife(0.0);
        }
        return String.format("You use %s and cause %.0f of damage!", hero.getSkills().get(index).getName(), damage);
    }

    public String printDungeonLvl(){
        return "Room: " + getRoom() + "  /  Floor: " + getFloor();
    }

    public String isLevelUp(){
        if(hero.getExperience() >= hero.getMaxExperience()){
            hero.LevelUp();
            return "You got a new level!!\n";
        }
        else{
            return "";
        }
    }

    public String enemyDrop(){
        hero.getBackpack().addItem(generatePotion());
        hero.getBackpack().addItem(generatePotion());
        hero.setExperience(hero.getExperience() + spawnedEnemy.getExperienceDrop());
        return String.format("The enemy drops %d of experience...", spawnedEnemy.getExperienceDrop());
    }        
}
