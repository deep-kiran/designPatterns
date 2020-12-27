package chainofresponsibility.brokerchain;

public class Creature {
    private Game game;
    public String name;
    public int baseAttack;
    public int baseDefense;

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    public int getBaseAttack() {
        Query query = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queryEvent.fire(query);
        return query.result;
    }

    public int getDefense() {
        Query query = new Query(name, Query.Argument.DEFENSE, baseAttack);
        game.queryEvent.fire(query);
        return query.result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "game=" + game +
                ", name='" + name + '\'' +
                ", baseAttack=" + getBaseAttack() +
                ", baseDefense=" + getDefense() +
                '}';
    }
}
