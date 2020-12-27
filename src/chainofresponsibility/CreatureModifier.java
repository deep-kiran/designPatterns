package chainofresponsibility;

public class CreatureModifier {
    protected Creature creature;
    CreatureModifier next;
    CreatureModifier(Creature creature){
        this.creature=creature;
    }
    public void handle(){
        if(next !=null){
            next.handle();
        }
    }
}
