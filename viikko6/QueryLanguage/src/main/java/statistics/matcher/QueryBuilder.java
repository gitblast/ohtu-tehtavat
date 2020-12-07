/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author jmammela
 */
public class QueryBuilder {

    private Matcher m;

    public QueryBuilder() {
        this.m = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.m = new And(m, new PlaysIn(team));

        return this;
    }

    public QueryBuilder hasAtLeast(int n, String field) {
        this.m = new And(m, new HasAtLeast(n, field));

        return this;
    }

    public QueryBuilder hasFewerThan(int n, String field) {
        this.m = new And(m, new HasFewerThan(n, field));

        return this;
    }

    public QueryBuilder oneOf(Matcher first, Matcher second) {
        this.m = new Or(first, second);

        return this;
    }

    public Matcher build() {
        Matcher temp = m;

        m = new All();

        return temp;
    }

}
