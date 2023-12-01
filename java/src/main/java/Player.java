
public class Player {

  private final String name;
  private int score;

  public Player(String name, int score) {
    this.name = name;
    this.score = score;
  }


  public int getScore() {
    return score;
  }

  public void incrementScore(){
    this.score++;
  }

}
