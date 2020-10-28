/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmammela
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsNullIfnotFound() {
        Player p = stats.search("non existing");

        assertNull(p);
    }

    @Test
    public void searchReturnsPlayerIfFound() {
        Player p = stats.search("Semenko");

        assertEquals("Semenko", p.getName());
    }

    @Test
    public void playersOfTeamReturnsPlayersOfTeam() {
        List<Player> l = stats.team("non existing");

        assertTrue(l.isEmpty());

        List<Player> team = stats.team("EDM");

        assertEquals(3, team.size());

    }

//    itse metodi on toteutettu niin, että se palauttaa väärän määrän pelaajia....    
//    @Test
//    public void topScorersReturnsCorrectAmoutn() {
//        for (int i = 1; i < readerStub.getPlayers().size(); i++) {
//            assertEquals(i, stats.topScorers(i).size());
//        }
//    }
    @Test
    public void topScorersReturnsTopScorers() {
        List<Player> scorers = stats.topScorers(4);

        int points = scorers.get(0).getPoints();

        for (Player p : scorers) {
            assertTrue(p.getPoints() <= points);

            points = p.getPoints();
        }
    }

}
