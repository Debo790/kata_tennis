import java.util.Map;

public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private final Map<Integer, String> pointToScoreString = Map.of(0, "Love-All", 1, "Fifteen-All", 2, "Thirty-All");

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (scorePlayer1 == scorePlayer2)
        {
            score = pointToScoreString.getOrDefault(scorePlayer1, "Deuce");
        }
        else if (scorePlayer1 >=4 || scorePlayer2 >=4)
        {

            score = calculateScore(scorePlayer1, scorePlayer2);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scorePlayer1;
                else { score+="-"; tempScore = scorePlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private static String calculateScore(int scorePlayer1, int scorePlayer2) {
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
