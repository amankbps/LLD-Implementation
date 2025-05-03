package snakeandladder;

public class Dice {
    private static final int MAX_VALUE=6;
    private static final int MIN_VALUE=1;

    public int roll(){
        return (int)(Math.random()*(MAX_VALUE-MIN_VALUE+1)+MIN_VALUE);
    }
}
