public class TennisGame1 implements TennisGame {


    private final Referee referee;
    private final Board board = new Board();


    public TennisGame1() {
        this.referee = new Referee();
    }

    public void wonPoint(String playerName) {
        referee.assignPoint(playerName);
    }

    public String getScore() {
        return board.scoreToHumanReadablePunteggio(referee);
    }
}
