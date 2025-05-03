package snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String>player=new ArrayList<>();
        player.add("Aman");
        player.add("suman");
        SnakeAndLadderGame snakeAndLadderGame=new SnakeAndLadderGame(player);
        snakeAndLadderGame.play();
     }
}
