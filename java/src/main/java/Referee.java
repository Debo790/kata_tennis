public class Referee {

  private Player player1 = new Player("player1", 0);
  private Player player2 = new Player("player2", 0);

  public void assignPoint(String playerName) {
    if ("player1".equals(playerName)) {
      player1.incrementScore();
    } else {
      player2.incrementScore();
    }
  }

  public Integer getScorePlayer1() {
    return player1.getScore();
  }

  public Integer getScorePlayer2() {
    return player2.getScore();
  }
}
