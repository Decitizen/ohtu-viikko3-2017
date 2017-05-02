package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class Not implements Matcher {
    
    private boolean match;
    private Matcher matcher;

    public Not(Matcher matcher) {
        this.match = match;
        this.matcher = matcher;
    }

    public Not() {
    }
    
    @Override
    public boolean matches(Player p) {
        if (matcher.matches(p)) return false;
        else return true;
    }
    
    @Override
    public String getType() {
        return "not";
    }
    
}
