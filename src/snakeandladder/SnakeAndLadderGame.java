package snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private int currentPlayerIndex;
    public SnakeAndLadderGame(List<String> players) {
        this.board = new Board();
        dice = new Dice();
        this.currentPlayerIndex = 0;
        this.players = new ArrayList<>();
        for (String name : players) {
             this.players.add(new Player(name));
        }
    }

    public void play(){

        while (!isGameOver()){
            Player currentPlayer = players.get(currentPlayerIndex);
            int diceRoll = dice.roll();
            int newPosition = currentPlayer.getPosition()+diceRoll;

            if(newPosition<= board.getBoardSize()){
                currentPlayer.setPosition(board.getPositionAfterSnakeOrLadder(newPosition));
                System.out.println(currentPlayer.getName()+" rolled a "+diceRoll+
                        " and moved to position "+newPosition);
            }
            if(currentPlayer.getPosition()==board.getBoardSize()){
                System.out.println(currentPlayer.getName()+" won the game");
                break;
            }
            currentPlayerIndex=(currentPlayerIndex+1)%players.size();
        }
    }

    private boolean isGameOver(){
        for(Player player : players){
            if(player.getPosition()== board.getBoardSize()){
                return true;
            }
        }
        return false;
    }
}
