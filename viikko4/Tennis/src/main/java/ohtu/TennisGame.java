package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScoreString(int points) {
        switch (points) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return null;
        }
    }

    public String getAdvOrWinString(String player, int diff) {
        if (diff == 1) {
            return "Advantage " + player;
        } else {
            return "Win for " + player;
        }
    }

    public String getScore() {
        if (m_score1 < 4 && m_score2 < 4) {
            if (m_score1 == m_score2) {
                return getScoreString(m_score1) + "-All";
            } else {
                return getScoreString(m_score1) + "-" + getScoreString(m_score2);
            }
        }

        int diff = Math.abs(m_score1 - m_score2);

        if (m_score1 > m_score2) {
            return getAdvOrWinString("player1", diff);
        }

        if (m_score1 < m_score2) {
            return getAdvOrWinString("player2", diff);
        }

        return "Deuce";

    }
}
