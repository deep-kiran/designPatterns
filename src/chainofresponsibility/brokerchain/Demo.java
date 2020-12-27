package chainofresponsibility.brokerchain;

public class Demo {
    public static void main(String[] args) {
        Game game =new Game();
        Creature goblin = new Creature(game,"Goblin",2,2);
        System.out.println(goblin);
        IncreaseDefenseModifier icm =new IncreaseDefenseModifier(game,goblin);
        try{
            DoubleAttackModifier dam = new DoubleAttackModifier(game,goblin);
            System.out.println(goblin);
            dam.close();

        }catch (Exception e){

        }
        System.out.println(goblin);
    }

}
