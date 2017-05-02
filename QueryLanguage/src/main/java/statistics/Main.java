package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new Or( 
                        new And(
                            new HasFewerThan(12, "assists"), new PlaysIn("CHI")),
                        new And(new HasAtLeast(30, "goals"), new Not(new PlaysIn("SJS")))
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
