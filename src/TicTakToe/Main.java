package TicTakToe;

public class Main {
    public static void main(String[] args) {
        Player player1=new Player("Aman",'O');
        Player player2=new Player("Bob",'X');
        Game game=new Game(player1,player2);
        game.play();
    }
}
