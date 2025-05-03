package snakeandladder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE=100;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    public Board() {
        snakes = new ArrayList<>();
        ladders=new ArrayList<>();
        initializeBord();
    }

    private void initializeBord() {

        //initialize snakes
        snakes.add(new Snake(16,6));
        snakes.add(new Snake(48,26));
        snakes.add(new Snake(64,60));
        snakes.add(new Snake(93,73));
        snakes.add(new Snake(99,6));

        //initialize ladder
        ladders.add(new Ladder(1,38));
        ladders.add(new Ladder(4,14));
        ladders.add(new Ladder(9,31));
        ladders.add(new Ladder(21,42));
        ladders.add(new Ladder(51,57));
        ladders.add(new Ladder(71,62));
    }

    public int getBoardSize(){
        return BOARD_SIZE;
    }
    public int getPositionAfterSnakeOrLadder(int position){

        for(Snake snake:snakes){
            if(snake.getStart()==position){
                return snake.getEnd();
            }
        }

        for(Ladder ladder:ladders){
            if(ladder.getStart()==position){
                return ladder.getEnd();
            }
        }
        return position;
    }


}
