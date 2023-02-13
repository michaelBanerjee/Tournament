import java.util.Random;
import java.lang.Math;

public class Battle {
    private Contestant player1;
    private Contestant player2;
    private int turnCount;
    
    public Battle(Contestant player1, Contestant player2){
        this.player1 = player1;
        this.player2 = player2;
        this.turnCount = 0;
        
    }
    // battle functions
    public void startTurn(){
        setTurnCount(getTurnCount() + 1);
        System.out.println("-- Turn "+getTurnCount()+" --");

        // ranomizes damage done from .3 - 1.5
        Random rand = new Random();

        Double multiplier = rand.nextDouble(.1, 2.0);
        player1.attack(player2, checkMissAndFormat(multiplier)); // player 1 attacks, critcal if > 1.7 and miss if <.5

        Double multiplier2 = rand.nextDouble(1., 2.0);
        player2.attack(player1, checkMissAndFormat(multiplier2)); // player 2 attacks, critcal if > 1.7 and miss if <.5

    }
    
    public double checkMissAndFormat(double multiplier){
        if (multiplier <= .5){
            multiplier = 0.0;
        }
        else if (multiplier >= 1.7){
            multiplier = 2.0;
        }
        return Math.floor(multiplier * 10) / 10;
        
    }

    public void printWinner(Contestant winner, Contestant loser){
        System.out.println(loser + " died! " + winner + " has won!");
    }

    public Contestant[] declareWinnerAndLoser(){
        if (player1.getAlive()){
            return new Contestant[] {player1, player2};
        }
        else if(player2.getAlive()){
            return new Contestant[] {player2, player1};
        }
        else{
            return new Contestant[] {player1, player1};
        }
    }
    public Contestant startBattle(){

        // until a player dies
        while(player1.getAlive() && player2.getAlive()){ 
            startTurn();
        }

        // prints winner and returns them
        Contestant results[] = declareWinnerAndLoser();
        // if there is a draw (both die in last round)
        if (results[0].equals(results[1])){
            System.out.println("Both contestants have died! To decide the winner, there will be a coin flip!");
            Contestant[] newWinnerIs = new Contestant[]{player1, player2};
            Random randArray = new Random();
            int newWinner = randArray.nextInt(0, 2);
            System.out.println(newWinnerIs[newWinner] + " has won the coin flip! They move on!");
            return newWinnerIs[newWinner];
        }
        // if there is a clear winner
        else{
            printWinner(results[0], results[1]);
            return results[0];
        }
        

        
    }

    // getters and setters for attributes
    public Contestant getPlayer1() {
        return player1;
    }
    public void setPlayer1(Contestant player1) {
        this.player1 = player1;
    }
    public Contestant getPlayer2() {
        return player2;
    }
    public void setPlayer2(Contestant player2) {
        this.player2 = player2;
    }
    public int getTurnCount() {
        return turnCount;
    }
    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

}
