package statistics;

import java.util.ArrayList;
import java.util.*;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

class QueryBuilder {
    private ArrayList<Matcher> matcherList;
    private boolean notFlag;
    
    public QueryBuilder() {
        matcherList = new ArrayList<>();
        notFlag = false;
    }
    
    public QueryBuilder and(Matcher... matchers) {
        for (Matcher matcher : matchers) {
            this.matcherList.add(matcher);
        }
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String fieldName) {
        return this.and(checkNotFlag(new HasAtLeast(amount, fieldName)));
    }
    
    public QueryBuilder hasFewerThan(int amount, String fieldName) {
        return this.and(checkNotFlag(new HasFewerThan(amount, fieldName)));
    }
    
    public QueryBuilder or(Matcher... matchers) {
        return this.and(new Or(matchers));
    }
    
    public QueryBuilder not() {
        this.notFlag = true;
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        return this.and(checkNotFlag(new PlaysIn(team)));
    }
    
    public Matcher build() {
        Matcher[] matchers = matcherList.toArray(new Matcher[0]);
        this.matcherList = new ArrayList<>();
        return new And(matchers);
    }
    
    public Matcher checkNotFlag(Matcher matcher) {
        if (notFlag) {
            this.notFlag = false;
            return new Not(matcher);
        }
        else return matcher;
    }

}
