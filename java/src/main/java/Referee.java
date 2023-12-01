public class Referee {

  private int scorePlayer1;
  private int scorePlayer2;

  public void assignPoint(String playerName) {
    if ("player1".equals(playerName)) {
      scorePlayer1++;
    } else {
      scorePlayer2++;
    }
  }

  public Integer getScore(String playerName) {
    if ("player1".equals(playerName)) {
      return scorePlayer1;
    } else {
      return scorePlayer2;
    }
  }
}
