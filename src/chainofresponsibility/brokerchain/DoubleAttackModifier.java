package chainofresponsibility.brokerchain;



public class DoubleAttackModifier extends CreatureModifier implements AutoCloseable{

    private int token;
    public DoubleAttackModifier(Game game,Creature creature){
        super(game,creature);
        //mediator wants to subscribe to all the queries
        token =game.queryEvent.subscribe(query -> {
            if (query.creatureName.equals(creature.name)
                && query.argument ==Query.Argument.ATTACK
            ){
                query.result *=2;
            }
        });
    }

    @Override
    public void close()  {
        game.queryEvent.unsubscribe(token);
    }
}
