package entities;

import java.io.IOException;
import java.util.Scanner;

public class Screen {

    public static void printCorridor() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|  \\                 /  |\n");
        sb.append("|    \\             /  ~ |\n");
        sb.append("|      \\ _______ /      |\n");
        sb.append("| ~     |       |       |\n");
        sb.append("|       |       |   ~   |\n");
        sb.append("|       |       |       |\n");
        sb.append("|    ~  |       | ~     |\n");
        sb.append("|       |_______|       |\n");
        sb.append("|      /__/___\\__\\      |\n");
        sb.append("|  ~ /__/___|___\\__\\  ~ |\n");
        sb.append("|  /__/___/___\\___\\__\\  |\n");
        sb.append("|/__/___/___|___\\___\\__\\|\n");
        System.out.println(sb.toString());
    }

    public static void printTreasure() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|                       |\n");
        sb.append("|                       |\n");
        sb.append("|                       |\n");
        sb.append("|                       |\n");
        sb.append("|     _____________     |\n");
        sb.append("|    |_____[*]_____|    |\n");
        sb.append("|    |             | ~  |\n");
        sb.append("|    |_____________|    |\n");
        sb.append("|      /__/___\\__\\      |\n");
        sb.append("|  ~ /__/___|___\\__\\  ~ |\n");
        sb.append("|  /__/___/___\\___\\__\\  |\n");
        sb.append("|/__/___/___|___\\___\\__\\|\n");
        System.out.println(sb.toString());
    }

    public static void printInventory() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|                       |\n");
        sb.append("|     _____________     |\n");
        sb.append("|    |  \\       /  |    |\n");
        sb.append("|    |   \\__.__/   |    |\n");
        sb.append("|    |             |    |\n");
        sb.append("|    |             |    |\n");
        sb.append("|    |             |    |\n");
        sb.append("|   _|_____________|_   |\n");
        sb.append("|  (  ||         ||  )  |\n");
        sb.append("|  (__||_________||__)  |\n");
        sb.append("|                       |\n");
        sb.append("|_______________________|\n");
        System.out.println(sb.toString());
    }

    public static void printNextLevel() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|  \\                 /  |\n");
        sb.append("|    \\  _________  /  ~ |\n");
        sb.append("|     /  _______  \\     |\n");
        sb.append("| ~   | |       | |     |\n");
        sb.append("|     | |   _   | | ~   |\n");
        sb.append("|     | |  /_\\  | |     |\n");
        sb.append("|     | | /___\\ | |     |\n");
        sb.append("|     |_|/_____\\|_|     |\n");
        sb.append("|      /__/___\\__\\      |\n");
        sb.append("|  ~ /__/___|___\\__\\  ~ |\n");
        sb.append("|  /__/___/___\\___\\__\\  |\n");
        sb.append("|/__/___/___|___\\___\\__\\|\n");
        System.out.println(sb.toString());
    }

    public static void printMonster() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|                       |\n");
        sb.append("|                       |\n");
        sb.append("|         #####         |\n");
        sb.append("|       ## ### ##       |\n");
        sb.append("|       #   #   #       |\n");
        sb.append("|        ### ###        |\n");
        sb.append("|         #####         |\n");
        sb.append("|         # # #    ~    |\n");
        sb.append("|      /__/___\\__\\      |\n");
        sb.append("|  ~ /__/___|___\\__\\  ~ |\n");
        sb.append("|  /__/___/___\\___\\__\\  |\n");
        sb.append("|/__/___/___|___\\___\\__\\|\n");
        System.out.println(sb.toString());
    }

    public static void printInitialScreen() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|                       |\n");
        sb.append("|      ESCAPE FROM      |\n");
        sb.append("|    PROMPT  DUNGEON    |\n");
        sb.append("|     _____________     |\n");
        sb.append("|    /             \\    |\n");
        sb.append("|   /   _________   \\   |\n");
        sb.append("|  /   /         \\   \\  |\n");
        sb.append("|  |   |         |   |  |\n");
        sb.append("|  |   |         |   |  |\n");
        sb.append("|  |   |         |   |  |\n");
        sb.append("|  |   |         |   |  |\n");
        sb.append("|__|___|__v1.0___|___|__|\n");
        System.out.println(sb.toString());
    }

    public static void printGameOver() {

        StringBuilder sb = new StringBuilder();

        sb.append(" _______________________\n");
        sb.append("|                       |\n");
        sb.append("|               []      |\n");
        sb.append("|              //       |\n");
        sb.append("|             //        |\n");
        sb.append("|         [=======]     |\n");
        sb.append("|          /   /        |\n");
        sb.append("|         /   /         |\n");
        sb.append("|        /   /          |\n");
        sb.append("|_______/___/___________|\n");
        sb.append("|                       |\n");
        sb.append("|       GAME OVER       |\n");
        sb.append("|_______________________|\n");
        System.out.println(sb.toString());
    }


    public static void printHelp() throws InterruptedException {
        System.out.println("# Welcome to Prompt Dungeon...");
        System.out.println("# You will control a hero who woke up in a dungeon...");
        System.out.println("# There will be 10 floors with 10 rooms on each floor...");
        System.out.println(
                "# Have two ways to increasy your stats:\n" 
                + " Colect strength and defence potions to increasy your stats permanently\n"
                + " or when you level up, completing your experience attribute ");
        System.out.println("# To interact with the menus, press the letter\n" + "or number that will appear between '[]'...");
        System.out.println("abbreviations:");
        System.out.println("DM: Damage Multiplier");
        System.out.println("MC: Mana Cost");
        System.out.println("RV: Recovery or Add Value");
        System.out.println("QT: Quantity");
        System.out.println();
        System.out.println("# Tip: Remember to recovery all you stats and use all str and def potions before enter in combat");
        System.out.println();
        System.out.println("Have a nice game ;)");
    }

    public static void waitKey(Scanner scan) {
        System.out.print("Press ENTER to continue...");
        scan.nextLine();
    }

    public static void progressBar() throws InterruptedException {
        int i = 0;
        while (i < 21) {
            System.out.print("[");
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            for (int j = 0; j < 20 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("]");
            if (i < 20) {
                System.out.print("\r");
                Thread.sleep(150);
            }
            i++;
        }
        System.out.println();
    }

    // Cleans console
    public static void clearConsole() throws InterruptedException, IOException {

        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033\143");
        }

    }
    
}
