import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final String scoreTemplate = "%s-%s";
    private static final Map<Integer, String> deucesToScoreString = Map.of(0, "Love-All", 1, "Fifteen-All", 2, "Thirty-All");
    private static final Map<Integer, String> pointToScoreString = Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");
    
    private final Referee referee = new Referee();

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        referee.assignPoint(playerName);
    }

    public String getScore() {
        int scorePlayer1 = referee.getScore("player1");
        int scorePlayer2 = referee.getScore("player2");
        if (scorePlayer1 == scorePlayer2) {
            return deucesToScoreString.getOrDefault(scorePlayer1, "Deuce");
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return calculateAdvantagesOrWin(scorePlayer1, scorePlayer2);
        } else {
            String scorePlayer1Str = pointToScoreString.get(scorePlayer1);
            String scorePlayer2Str = pointToScoreString.get(scorePlayer2);
            return scoreTemplate.formatted(scorePlayer1Str, scorePlayer2Str);
        }
    }

    private static String calculateAdvantagesOrWin(int scorePlayer1, int scorePlayer2) {
        int scoreDifference = scorePlayer1 - scorePlayer2;
        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}
