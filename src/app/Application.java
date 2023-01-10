package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Backpack;
import entities.Dungeon;
import entities.Hero;
import entities.Screen;
import entities.Skill;
import enums.Dice;

public class Application {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Screen.clearConsole();
        Screen.printInitialScreen();
        System.out.println("Created by Ruderson Florentino");
        System.out.println("https://github.com/Rudersonvf");
        System.out.println();
        Screen.progressBar();
        Screen.waitKey(sc);
        Screen.clearConsole();
        System.out.println("########### HELP ##########");
        Screen.printHelp();
        Screen.waitKey(sc);
        Screen.clearConsole();

        // Init game
        System.out.print("Enter the hero name: ");
        String name = sc.nextLine();

        Dungeon dungeon = new Dungeon(1, 1);
        dungeon.setHero(new Hero(name, 500.0, 500.0, 100.0, 100.0, 35.0, 10.0, 100, 0, 1));
        dungeon.getHero().setBackpack(new Backpack(50, 0));
        dungeon.getHero().getSkills().add(new Skill("Slash", 1.25, 10.0));
        while (dungeon.isGameOver() != true) {
            try {
                Screen.clearConsole();
            Screen.printCorridor();
            System.out.println(dungeon.printDungeonLvl());
            System.out.println();
            System.out.println(dungeon.getHero().printHeroStatus());
            System.out.println("What will you do ?");
            System.out.print("[W]alk  /  [I]nventory  /  Hero [S]tatus  /  [H]elp: ");
            char answer = sc.next().toUpperCase().charAt(0);
            if (answer == 'W') {
                int diceResult = Dice.rollDice();
                switch (diceResult) {
                    case 1,3,5,7:
                        sc.nextLine();
                    break;
                    case 2, 4, 6:
                        Screen.clearConsole();
                        Screen.printMonster();
                        System.out.println("A monster appear!\nPrepare to battle!");
                        Screen.progressBar();
                        dungeon.setSpawnedEnemy(dungeon.spawnEnemy());
                        while (dungeon.isGameOver() != true && dungeon.isEndBattle() != true) {
                            Screen.clearConsole();
                            Screen.printMonster();
                            System.out.println(dungeon.getSpawnedEnemy().printEnemyStatus());
                            System.out.println(dungeon.getHero().printHeroStatus());
                            int turn = 0;
                            while (dungeon.isEndTurn(turn) != true) {
                                System.out.println("Hero turn:");
                                System.out.println("What will do?");
                                System.out.print("[A]ttack  /  Use [S]kill  /  [I]nventory ");
                                answer = sc.next().toUpperCase().charAt(0);
                                if (answer == 'A') {
                                    System.out.println(dungeon.heroNormalAttack());
                                    turn++;
                                    dungeon.isEndTurn(turn);
                                } 
                                else if (answer == 'S') {
                                    dungeon.getHero().printSkill();
                                    System.out.print("Enter Skill index: ");
                                    try {
                                        int index = sc.nextInt();
                                        if (dungeon.haveMana(index) == true) {
                                            System.out.println(dungeon.heroSkillAttack(index));
                                            turn++;
                                            dungeon.isEndTurn(turn);
                                        } 
                                        else {
                                            System.out.println("Dont have mana!");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                } 
                                else if (answer == 'I') {
                                    Screen.clearConsole();
                                    Screen.printInventory();
                                    System.out.println(dungeon.getHero().getBackpack().printBackpack());
                                    System.out.println();
                                    System.out.println(dungeon.getHero().printHeroFullStatus());
                                    System.out.println();
                                    dungeon.getHero().getBackpack().printBackpackItems();
                                    System.out.print("Use [P]otion  /  [R]eturn: ");
                                    answer = sc.next().toUpperCase().charAt(0);
                                    try {
                                        if (answer == 'P') {
                                            System.out.print("Enter item index: ");
                                            int index = sc.nextInt();
                                            dungeon.getHero().usePotion(index);
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                    
                                    turn++;
                                    dungeon.isEndTurn(turn);
                                } 
                                else {
                                    System.out.println("Invalid option! Try again...");
                                }
                                sc.nextLine();
                                Screen.waitKey(sc);
                                Screen.clearConsole();
                                Screen.printMonster();
                                System.out.println(dungeon.getSpawnedEnemy().printEnemyStatus());
                                System.out.println(dungeon.getHero().printHeroStatus());
                            }
                            if(dungeon.isEndBattle() != true){
                                System.out.println("Enemy turn:");
                                System.out.println(dungeon.enemyAttack());
                                Screen.waitKey(sc);
                            }
                            if(dungeon.getSpawnedEnemy().getLife() <= 0){
                                System.out.println("You defeated the enemy!");
                                System.out.println(dungeon.enemyDrop());
                                System.out.println(dungeon.isLevelUp());
                                dungeon.getHero().newSkill();
                            }
                        }
                        break;
                    case 8:
                        Screen.clearConsole();
                        Screen.printTreasure();
                        System.out.println("You found a treasure box!");
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        sc.nextLine();
                    break;
                }
                System.out.println(dungeon.updateDungeon());
                Screen.waitKey(sc);
            } 
            else if (answer == 'I') {
                Screen.clearConsole();
                Screen.printInventory();
                System.out.println(dungeon.getHero().getBackpack().printBackpack());
                System.out.println();
                System.out.println(dungeon.getHero().printHeroBackpackStatus());
                System.out.println();
                dungeon.getHero().getBackpack().printBackpackItems();
                if(dungeon.getHero().getBackpack().getPotions().size() > 0){
                    System.out.print("Use [P]otion  /  [D]elete Potion  /  [R]eturn: ");
                    answer = sc.next().toUpperCase().charAt(0);
                }
                if (answer == 'P') {
                    System.out.print("Enter item index: ");
                    int index = sc.nextInt();
                    dungeon.getHero().usePotion(index);
                }
                if(answer == 'D'){
                    System.out.print("Enter item index to delete: ");
                    int index = sc.nextInt();
                    dungeon.getHero().deletePotion(index);
                }
                sc.nextLine();
                Screen.waitKey(sc);
            } 
            else if (answer == 'S') {
                Screen.clearConsole();
                Screen.printInventory();
                System.out.println(dungeon.getHero().printHeroFullStatus());
                System.out.println("Skill List: ");
                dungeon.getHero().printSkill();
                sc.nextLine();
                Screen.waitKey(sc);
            } 
            else {
                Screen.clearConsole();
                Screen.printInitialScreen();
                Screen.printHelp();
                sc.nextLine();
                Screen.waitKey(sc);
            }Screen.clearConsole();
            Screen.printCorridor();
            System.out.println(dungeon.printDungeonLvl());
            System.out.println();
            System.out.println(dungeon.getHero().printHeroStatus());
            System.out.println("What will you do ?");
            System.out.print("[W]alk  /  [I]nventory  /  Hero [S]tatus  /  [H]elp: ");
            answer = sc.next().toUpperCase().charAt(0);
            if (answer == 'W') {
                int diceResult = Dice.rollDice();
                switch (diceResult) {
                    case 1,3,5,7:
                        sc.nextLine();
                    break;
                    case 2, 4, 6:
                        Screen.clearConsole();
                        Screen.printMonster();
                        System.out.println("A monster appear!\nPrepare to battle!");
                        Screen.progressBar();
                        dungeon.setSpawnedEnemy(dungeon.spawnEnemy());
                        while (dungeon.isGameOver() != true && dungeon.isEndBattle() != true) {
                            Screen.clearConsole();
                            Screen.printMonster();
                            System.out.println(dungeon.getSpawnedEnemy().printEnemyStatus());
                            System.out.println(dungeon.getHero().printHeroStatus());
                            int turn = 0;
                            while (dungeon.isEndTurn(turn) != true) {
                                System.out.println("Hero turn:");
                                System.out.println("What will do?");
                                System.out.print("[A]ttack  /  Use [S]kill  /  [I]nventory: ");
                                answer = sc.next().toUpperCase().charAt(0);
                                if (answer == 'A') {
                                    System.out.println(dungeon.heroNormalAttack());
                                    turn++;
                                    dungeon.isEndTurn(turn);
                                } 
                                else if (answer == 'S') {
                                    dungeon.getHero().printSkill();
                                    System.out.print("Enter Skill index: ");
                                    try {
                                        int index = sc.nextInt();
                                        if (dungeon.haveMana(index) == true) {
                                            System.out.println(dungeon.heroSkillAttack(index));
                                            turn++;
                                            dungeon.isEndTurn(turn);
                                        } 
                                        else {
                                            System.out.println("Dont have mana!");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                } 
                                else if (answer == 'I') {
                                    Screen.clearConsole();
                                    Screen.printInventory();
                                    System.out.println(dungeon.getHero().getBackpack().printBackpack());
                                    System.out.println();
                                    System.out.println(dungeon.getHero().printHeroFullStatus());
                                    System.out.println();
                                    dungeon.getHero().getBackpack().printBackpackItems();
                                    System.out.print("Use [P]otion  /  [R]eturn: ");
                                    answer = sc.next().toUpperCase().charAt(0);
                                    try {
                                        if (answer == 'P') {
                                            System.out.print("Enter item index: ");
                                            int index = sc.nextInt();
                                            dungeon.getHero().usePotion(index);
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                    
                                    turn++;
                                    dungeon.isEndTurn(turn);
                                } 
                                else {
                                    System.out.println("Invalid option! Try again...");
                                }
                                sc.nextLine();
                                Screen.waitKey(sc);
                                Screen.clearConsole();
                                Screen.printMonster();
                                System.out.println(dungeon.getSpawnedEnemy().printEnemyStatus());
                                System.out.println(dungeon.getHero().printHeroStatus());
                            }
                            if(dungeon.isEndBattle() != true){
                                System.out.println("Enemy turn:");
                                System.out.println(dungeon.enemyAttack());
                                Screen.waitKey(sc);
                            }
                            if(dungeon.getSpawnedEnemy().getLife() <= 0){
                                System.out.println("You defeated the enemy!");
                                System.out.println(dungeon.enemyDrop());
                                System.out.println(dungeon.isLevelUp());
                                dungeon.getHero().newSkill();
                            }
                        }
                        break;
                    case 8:
                        Screen.clearConsole();
                        Screen.printTreasure();
                        System.out.println("You found a treasure box!");
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        dungeon.getHero().getBackpack().addItem(dungeon.generatePotion());
                        sc.nextLine();
                    break;
                }
                System.out.println(dungeon.updateDungeon());
                Screen.waitKey(sc);
            } 
            else if (answer == 'I') {
                Screen.clearConsole();
                Screen.printInventory();
                System.out.println(dungeon.getHero().getBackpack().printBackpack());
                System.out.println();
                System.out.println(dungeon.getHero().printHeroBackpackStatus());
                System.out.println();
                dungeon.getHero().getBackpack().printBackpackItems();
                if(dungeon.getHero().getBackpack().getPotions().size() > 0){
                    System.out.print("Use [P]otion  /  [D]elete Potion  /  [R]eturn: ");
                    answer = sc.next().toUpperCase().charAt(0);
                }
                if (answer == 'P') {
                    System.out.print("Enter item index: ");
                    int index = sc.nextInt();
                    dungeon.getHero().usePotion(index);
                }
                if(answer == 'D'){
                    System.out.print("Enter item index to delete: ");
                    int index = sc.nextInt();
                    dungeon.getHero().deletePotion(index);
                }
                sc.nextLine();
                Screen.waitKey(sc);
            } 
            else if (answer == 'S') {
                Screen.clearConsole();
                Screen.printInventory();
                System.out.println(dungeon.getHero().printHeroFullStatus());
                System.out.println("Skill List: ");
                dungeon.getHero().printSkill();
                sc.nextLine();
                Screen.waitKey(sc);
            } 
            else {
                Screen.clearConsole();
                Screen.printInitialScreen();
                Screen.printHelp();
                sc.nextLine();
                Screen.waitKey(sc);
            }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        Screen.clearConsole();
        Screen.printGameOver();
        Screen.waitKey(sc);
        sc.close();
    }

}
