package chainofresponsibility.brokerchain;


public class IncreaseDefenseModifier extends CreatureModifier {

    private int token;
    public IncreaseDefenseModifier(Game game,Creature creature){
        super(game,creature);
        //mediator wants to subscribe to all the queries
        token =game.queryEvent.subscribe(query -> {
            if (query.creatureName.equals(creature.name)
                    && query.argument ==Query.Argument.DEFENSE
            ){
                query.result +=4;
            }
        });
    }

}

