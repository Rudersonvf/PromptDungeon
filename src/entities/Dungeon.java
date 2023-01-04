package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

    private final String path = "C:\\temp\\enemies.csv";
    
    private Integer floor;
    private Integer room;

    private Hero hero;
    private List<Enemy> enemies = new ArrayList<>();
    private Screen screen;

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

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void addEnemiesToList(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.toString().split(",");
                enemies.add(new Enemy(fields[0], Double.parseDouble(fields[1]), Double.parseDouble(fields[2]),
                Integer.parseInt(fields[3]), Integer.parseInt(fields[4])));
                line = br.readLine();
            }
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Generate a random enemy from the list according to the dungeon floor
    public Enemy spawnEnemy(){
        List<Enemy> enemySpawList = new ArrayList<>();
        Enemy enemy = new Enemy(null, null, null, null, null);
        Random random = new Random();
        final int minFloorRange = 2;
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
}
