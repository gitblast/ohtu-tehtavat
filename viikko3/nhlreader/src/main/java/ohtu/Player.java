package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String nationality;
    private String team;
    private int assists;
    private int goals;
    private int penalties;
    private int games;

    public Player(String name, String nationality, String team, int assists, int goals, int penalties, int games) {
        this.name = name;
        this.nationality = nationality;
        this.team = team;
        this.assists = assists;
        this.goals = goals;
        this.penalties = penalties;
        this.games = games;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        String vali = "\t";

        if (name.length() < 16) {
            vali = "\t\t";
        }

        return name + vali + team + "\t" + goals + " + " + assists + " = " + (goals + assists);
    }

    @Override
    public int compareTo(Player other) {
        return other.getPoints() - this.getPoints();
    }

}
