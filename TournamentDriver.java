
public class TournamentDriver {
    public static void main(String[] args) {
        Contestant joe = new Contestant("Sydney", 5, 20);
        Contestant jill = new Contestant("Michelle", 5, 20);

        Battle battle1 = new Battle(joe, jill);
        battle1.startBattle();
        
    }
}
