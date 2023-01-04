package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Backpack;
import entities.Dungeon;
import entities.Hero;

public class Application {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        //Init game
        System.out.print("Enter the hero name: ");
        String name = sc.nextLine();

        Dungeon dungeon = new Dungeon(1, 1);
        dungeon.setHero(new Hero(name, 500.0, 500.0, 100.0, 100.0, 35.0, 10.0, 100, 0, 1));
        dungeon.getHero().setBackpack(new Backpack(50, 0));

        dungeon.getScreen().printMonster();
        

        sc.close();
    }
}
