package enums;

public enum Dice {
    
    D1(1),
    D2(2),
    D3(3),
    D4(4),
    D5(5),
    D6(6);

    private final int value;

    private Dice(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    //Retorna um valor aleatorio do dado
    public static int rollDice(){
        return values()[(int) (Math.random() * values().length)].getValue();
    }
    
}
