import java.util.Map;

public class Board {

  private static final String scoreTemplate = "%s-%s";
  private static final String deuceTemplate = "%s-All";
  private static final Map<Integer, String> pointToScoreString = Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");


  public String scoreToHumanReadablePunteggio(Referee referee){

    int scorePlayer1 = referee.getScorePlayer1();
    int scorePlayer2 = referee.getScorePlayer2();

    if (isDeuce(scorePlayer1, scorePlayer2)){
      return "Deuce";
    }

    if (scorePlayer1 >= 4 || scorePlayer2 >= 4){
      int scoreDifference = Math.abs(scorePlayer1 - scorePlayer2);
      if(scoreDifference >= 2){
        return getWinner(scorePlayer1, scorePlayer2);
      }
      if (scoreDifference == 1){
        return getAdvantaged(scorePlayer1, scorePlayer2);
      }
    }

    if (scorePlayer1 == scorePlayer2){
      return deuceTemplate.formatted(pointToScoreString.get(scorePlayer1));
    }

    String scorePlayer1Str = pointToScoreString.get(scorePlayer1);
    String scorePlayer2Str = pointToScoreString.get(scorePlayer2);
    return scoreTemplate.formatted(scorePlayer1Str, scorePlayer2Str);

  }

  private static String getAdvantaged(int scorePlayer1, int scorePlayer2) {
    if (scorePlayer1 > scorePlayer2) {
      return "Advantage player1";
    }
    return "Advantage player2";
  }

  private static String getWinner(int scorePlayer1, int scorePlayer2) {
    if (scorePlayer1 > scorePlayer2){
      return "Win for player1";
    }
    return "Win for player2";
  }

  private static boolean isDeuce(int scorePlayer1, int scorePlayer2) {
    return scorePlayer1 == scorePlayer2 && (scorePlayer1 == 3 || scorePlayer1 == 4);
  }

}
